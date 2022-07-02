package me.jincrates.bookmanager.domain.loan

import me.jincrates.bookmanager.domain.BaseEntity
import me.jincrates.bookmanager.domain.books.Book
import java.util.*
import javax.persistence.*

@Table(name = "loan_book")
@Entity
data class LoanBook(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_book_id")
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    var book: Book? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id")
    var loan: Loan? = null,

    var count: Int? = null

) : BaseEntity() {

    fun createLoanBook(book: Optional<Book>, count: Int): LoanBook {
       book.get().removeStock(count)
       return LoanBook().apply {
           this.book = book.get()
           this.count = count
       }
    }

    fun returnBook() {
        count?.let { this.book?.addStock(it) }
    }
}
