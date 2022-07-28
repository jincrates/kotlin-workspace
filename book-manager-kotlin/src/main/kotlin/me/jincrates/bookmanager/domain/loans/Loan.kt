package me.jincrates.bookmanager.domain.loans

import me.jincrates.bookmanager.domain.BaseEntity
import me.jincrates.bookmanager.domain.books.BookStatus
import me.jincrates.bookmanager.domain.members.Member
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Table(name = "loan")
@Entity
data class Loan(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id") var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private var member: Member? = null,

    private var fromDate: LocalDateTime? = LocalDateTime.now(),

    private var toDate: LocalDateTime? = LocalDateTime.now().plusDays(7),  // 7일간 대여 가능

    private var isReturn: Boolean? = false,

    @Enumerated(EnumType.STRING)
    private var loanStatus: BookStatus? = null,

    @OneToMany(mappedBy = "loan", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    private var loanBooks: MutableList<LoanBook> = mutableListOf(),

    ) : BaseEntity() {

    fun createLoan(member: Optional<Member>, loanBooks: MutableList<LoanBook>): Loan {
        val loan = Loan().apply {
            this.member = member.get()
        }

        loanBooks.forEach {
            loan.addLoanBook(it)
        }

        return loan
    }

    fun addLoanBook(loanBook: LoanBook) {
        loanBooks.add(loanBook)
        loanBook.setLoan(this)
    }

    fun cancelLoan() {
        this.isReturn = false;

        loanBooks.forEach {
            it.returnBook()
        }
    }

    fun extend() {
        //Todo 상태코드로 변경 에정
        var isReserved: Boolean = false;

        if(isReserved) {
        }

    }
}

