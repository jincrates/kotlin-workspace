package me.jincrates.bookmanager.domain.loans

import me.jincrates.bookmanager.common.Status
import me.jincrates.bookmanager.domain.books.Book
import me.jincrates.bookmanager.domain.books.BookRepository
import me.jincrates.bookmanager.domain.members.Member
import me.jincrates.bookmanager.domain.members.MemberRepository
import me.jincrates.bookmanager.domain.members.MemberRole
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@TestPropertySource(properties = ["spring.config.location=classpath:application.yml"])
@SpringBootTest
class LoanRepositoryTest {

    @Autowired
    lateinit var loanRepository: LoanRepository

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Autowired
    lateinit var bookRepository: BookRepository

    fun createMember(): Member {
        return Member().apply {
            this.name = "진크"
            this.email = "jincrates@email.com"
            this.password = "a12345!"
            this.joinDate = "2020-06-22 00:00:00"
            this.phoneNumber = "010-1111-2222"
            this.role = MemberRole.USER
            this.status = Status.ACTIVE
        }
    }

    fun makeBook(): Book {
        return Book().apply {
            this.title = "철학적 탐구"
            this.author = "루트비히 비트겐슈타인"
            this.publisher = "책세상"
            this.publicationDate = "2019-04-05 00:00:00"
            this.isbn = "9791159313554"
            this.stockNumber = 10
        }
    }

    @Test
    fun saveTest() {
        val book = makeBook()
        bookRepository.save(book)

        val member = createMember()
        memberRepository.save(member)

        val loanBook = Loan().apply {
            //this.book = book
            this.member = member
            this.fromDate = LocalDateTime.now()
            this.toDate = LocalDateTime.now().plusDays(7)
            this.isReturn = false
        }

        val result = loanRepository.save(loanBook)
        println(result)
    }

}