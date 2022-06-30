package me.jincrates.bookmanager.service

import me.jincrates.bookmanager.web.http.BookDto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@ExtendWith(SpringExtension::class)
@TestPropertySource(properties = ["spring.config.location=classpath:application.yml"])
@SpringBootTest
class BookServiceTest {

    @Autowired
    lateinit var bookService: BookService

    @Test
    fun createTest() {
        val bookDto = BookDto().apply {
            this.title = "철학적 탐구"
            this.author = "루트비히 비트겐슈타인"
            this.publisher = "책세상"
            this.publicationDate = "2019-04-05 00:00:00"
            this.isbn = "9791159313554"
            this.quantity = 10
//            this.createdAt = LocalDateTime.now()
//            this.updatedAt = LocalDateTime.now()
//            this.createdBy = "tempUser"
//            this.updatedBy = "tempUser"
        }

        val result = bookService.create(bookDto)

        assertNotNull(result)
        assertEquals("철학적 탐구", result?.title)
        assertEquals("루트비히 비트겐슈타인", result?.author)
        assertEquals("책세상", result?.publisher)
        assertEquals("2019-04-05 00:00:00", result?.publicationDate)
        assertEquals("9791159313554", result?.isbn)
        assertEquals(10, result?.quantity)
    }

    fun readTest() {

    }

    fun readAllTest() {

    }

    fun updateTest() {

    }

    fun deleteTest() {

    }

}