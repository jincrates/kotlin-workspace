package me.jincrates.bookmanager.domain.books

import me.jincrates.bookmanager.domain.Book
import me.jincrates.bookmanager.domain.BookRepository
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


}
