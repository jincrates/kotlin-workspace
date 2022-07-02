package me.jincrates.bookmanager.web

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import me.jincrates.bookmanager.web.http.dto.BookDto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.util.LinkedMultiValueMap

@AutoConfigureMockMvc
@ExtendWith(SpringExtension::class)
@TestPropertySource(properties = ["spring.config.location=classpath:application-test.yml"])
@SpringBootTest
class BookApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun readTest() {
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("id", "1")

        mockMvc.perform(
            get("/api/book").queryParams(queryParams)
        ).andExpect(
            status().isOk
        ).andDo(print())
    }

    @Test
    fun readFailTest() {
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("id", "-1")

        mockMvc.perform(
            get("/api/book").queryParams(queryParams)
        ).andExpect(
            status().isBadRequest
        ).andExpect(
            content().contentType("application/json")
        ).andExpect(
            jsonPath("\$.result_code").value("FAIL")
        ).andExpect(
            jsonPath("\$.errors[0].field").value("id")
        ).andExpect(
            jsonPath("\$.errors[0].value").value("1")
        ).andDo(print())
    }

    @Test
    fun createTest() {
        val bookDto = BookDto().apply {
            this.title = "철학적 탐구"
            this.author = "루트비히 비트겐슈타인"
            this.publisher = "책세상"
            this.publicationDate = "2019-04-05 00:00:00"
            this.isbn = "9791159313554"
            this.stockNumber = 10
        }

        val json = jacksonObjectMapper().writeValueAsString(bookDto)
        println(json)

        mockMvc.perform(
            post("/api/book")
                .content(json)
                .contentType("application/json")
                .accept("application/json")
        ).andExpect(
            status().isOk
        ).andExpect(
            jsonPath("\$.title").value("철학적 탐구")
        ).andExpect(
            jsonPath("\$.author").value("루트비히 비트겐슈타인")
        ).andExpect(
            jsonPath("\$.publisher").value("책세상")
        ).andExpect(
            jsonPath("\$.publication_date").value("2019-04-05 00:00:00")
        ).andExpect(
            jsonPath("\$.isbn").value("9791159313554")
        ).andExpect(
            jsonPath("\$.quantity").value("10")
        ).andDo(print())
    }

    @Test
    fun createFailTest() {
        val bookDto = BookDto().apply {
            this.title = "철학적 탐구"
            this.author = "루트비히 비트겐슈타인"
            this.publisher = ""
            this.publicationDate = "2019-04-05 00:00:00"
            this.isbn = "9791159313554"
            this.stockNumber = 10
        }

        val json = jacksonObjectMapper().writeValueAsString(bookDto)
        println(json)

        mockMvc.perform(
            post("/api/book")
                .content(json)
                .contentType("application/json")
                .accept("application/json")
        ).andExpect(
            status().`is`(400)
        ).andDo(print())
    }
}