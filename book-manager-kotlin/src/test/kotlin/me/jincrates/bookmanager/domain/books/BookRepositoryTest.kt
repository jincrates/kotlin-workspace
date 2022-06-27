package me.jincrates.bookmanager.domain.books

import me.jincrates.bookmanager.config.WebMvcConfig
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

    @Test
    fun saveTest() {
        val book = Book().apply {
            this.title = "소크라테스 익스프레스"
            this.author = "에릭 와이너"
            this.publisher = "어크로스"
            this.publicationDate = "2022-03-14 00:00:00"
            this.isbn = "9791190030922"
            this.quantity = 1
        }

        val result = bookRepository.save(book)
        println(result)

        assertNotNull(result)
        assertEquals("소크라테스 익스프레스", result.title)
        assertEquals("에릭 와이너", result.author)
        assertEquals("어크로스", result.publisher)
        assertEquals("2022-03-14 00:00:00", result.publicationDate)
        assertEquals("9791190030922", result.isbn)
        assertEquals(1, result.quantity)
    }
}