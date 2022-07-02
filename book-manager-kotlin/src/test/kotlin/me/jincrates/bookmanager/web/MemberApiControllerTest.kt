package me.jincrates.bookmanager.web

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc

@AutoConfigureMockMvc
@ExtendWith(SpringExtension::class)
@TestPropertySource(properties = ["spring.config.location=classpath:application.yml"])
@SpringBootTest
class MemberApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    fun create() {

    }

}