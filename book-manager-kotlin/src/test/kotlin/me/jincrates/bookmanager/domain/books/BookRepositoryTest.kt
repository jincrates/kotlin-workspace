package me.jincrates.bookmanager.domain.books

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@TestPropertySource(properties = ["spring.config.location=classpath:application.yml"])
//필요한 것만 넣어줘야 효율적으로 테스트가 가능하다.
//@SpringBootTest(classes = [BookRepository::class, WebMvcConfig::class])
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    lateinit var bookRepository: BookRepository

    fun makeBook(): Book {
        return Book().apply {
            this.title = "철학적 탐구"
            this.author = "루트비히 비트겐슈타인"
            this.publisher = "책세상"
            this.publicationDate = "2019-04-05 00:00:00"
            this.isbn = "9791159313554"
            this.quantity = 10
        }
    }

    fun makeBookList(): MutableList<Book> {
        return mutableListOf(
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
    }

    @Test
    fun saveTest() {
        val book = makeBook()
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
        val bookList = makeBookList()
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

    @Test
    fun findByIdTest() {
        val bookList = makeBookList()
        bookRepository.saveAll(bookList)

        val result = bookRepository.findById(3L).get()
        println(result)

        assertNotNull(result)
        assertEquals("방법서설", result.title)
        assertEquals("르네 데카르트", result.author)
        assertEquals("문예출판사", result.publisher)
        assertEquals("2022-05-30 00:00:00", result.publicationDate)
        assertEquals("9788931022759", result.isbn)
        assertEquals(10, result.quantity)
    }

    @Test
    fun updateTest() {
        val book = makeBook()
        val insertBook = bookRepository.save(book)

        val updateBook = Book().apply {
            this.id = insertBook.id
            this.title = "철학적 탐구 업데이트"
            this.author = insertBook.author
            this.publisher = "책세상 업데이트"
            this.publicationDate = insertBook.publicationDate
            this.isbn = insertBook.isbn
            this.quantity = 99
        }

        val result = bookRepository.save(updateBook)
        println(result)

        assertNotNull(result)
        assertEquals(insertBook.id, result.id)
        assertEquals("철학적 탐구 업데이트", result.title)
        assertEquals("책세상 업데이트", result.publisher)
        assertEquals(99, result.quantity)
    }

    @Test
    fun deleteByIdTest() {
        val bookList = makeBookList()
        bookRepository.saveAll(bookList)

        val beforeCnt = bookRepository.findAll().size
        bookRepository.deleteById(2L)

        val afterCnt = bookRepository.findAll().size
        println(bookRepository.existsById(2L))

        assertEquals(false, bookRepository.existsById(2L))
        assertEquals(beforeCnt - 1, afterCnt)
    }
}
