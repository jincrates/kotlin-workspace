package me.jincrates.bookmanager.domain.books

import me.jincrates.bookmanager.config.WebMvcConfig
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath

@ExtendWith(SpringExtension::class)
@TestPropertySource(properties = ["spring.config.location=classpath:application.yml"])
//필요한 것만 넣어줘야 효율적으로 테스트가 가능하다.
//@SpringBootTest(classes = [BookRepository::class, WebMvcConfig::class])
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    lateinit var bookRepository: BookRepository

    @Test
    fun saveTest() {
        val book = Book().apply {
            this.title = "철학적 탐구"
            this.author = "루트비히 비트겐슈타인"
            this.publisher = "책세상"
            this.publicationDate = "2019-04-05 00:00:00"
            this.isbn = "9791159313554"
            this.quantity = 10
        }

        val result = bookRepository.save(book)
        println(result)

        assertNotNull(result)
        assertEquals("철학적 탐구", result.title)
        assertEquals("루트비히 비트겐슈타인", result.author)
        assertEquals("책세상", result.publisher)
        assertEquals("2019-04-05 00:00:00", result.publicationDate)
        assertEquals("9791159313554", result.isbn)
        assertEquals(10, result.quantity)
    }

    @Test
    fun saveAllTest() {
        val bookList = mutableListOf(
            Book().apply {
                this.title = "철학적 탐구"
                this.author = "루트비히 비트겐슈타인"
                this.publisher = "책세상"
                this.publicationDate = "2019-04-05 00:00:00"
                this.isbn = "9791159313554"
                this.quantity = 10
            },
            Book().apply {
                this.title = "말과 사물"
                this.author = "미셸 푸코"
                this.publisher = "민음사"
                this.publicationDate = "2012-04-29 00:00:00"
                this.isbn = "9788937484414"
                this.quantity = 10
            },
            Book().apply {
                this.title = "방법서설"
                this.author = "르네 데카르트"
                this.publisher = "문예출판사"
                this.publicationDate = "2022-05-30 00:00:00"
                this.isbn = "9788931022759"
                this.quantity = 10
            },
        )

        val result = bookRepository.saveAll(bookList)
        println(result)

        assertNotNull(result)
        assertEquals("말과 사물", result[1].title)
        assertEquals("미셸 푸코", result[1].author)
        assertEquals("민음사", result[1].publisher)
        assertEquals("2012-04-29 00:00:00", result[1].publicationDate)
        assertEquals("9788937484414", result[1].isbn)
        assertEquals(10, result[1].quantity)
    }

}