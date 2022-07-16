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
    @Column(name = "loan_id")
    private var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private var member: Member? = null,

    private var fromDate: LocalDateTime? = null,

    private var toDate: LocalDateTime? = null,

    private var isReturn: Boolean? = null,

    @Enumerated(EnumType.STRING)
    private var loanStatus: BookStatus? = null,

    @OneToMany(mappedBy = "loan", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    private var loanBooks: MutableList<LoanBook> = mutableListOf()

) : BaseEntity() {

    fun createLoan(member: Optional<Member>, loanBooks: MutableList<LoanBook>): Loan {
        val loan = Loan().apply {
            this.member = member.get()
            this.isReturn = false
            this.fromDate = LocalDateTime.now()
            this.toDate = LocalDateTime.now().plusDays(7)  //7일간 대여 가능
        }

        loanBooks.forEach {
            loan.addLoanBook(it)
        }

        return loan
    }

    fun addLoanBook(loanBook: LoanBook) {
        loanBooks.add(loanBook)
        loanBook.loan = this
    }

    fun cancelLoan() {
        this.isReturn = false;

        loanBooks.forEach {
            it.returnBook()
        }
    }
}

