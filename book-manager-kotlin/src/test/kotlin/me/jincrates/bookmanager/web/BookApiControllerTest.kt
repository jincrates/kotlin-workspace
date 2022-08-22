package me.jincrates.bookmanager.web

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import me.jincrates.bookmanager.repository.BookRepository
import me.jincrates.bookmanager.model.BookRequest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = ["spring.config.location=classpath:application-test.yml"])
class BookApiControllerTest {
    @Autowired lateinit var mockMvc: MockMvc
    @Autowired lateinit var bookRepository: BookRepository

    @DisplayName("도서등록 - 입력값 정상")
    @Test
    fun createSuccessTest() {
        val bookRequest = BookRequest(
            title = "철학적 탐구",
            author = "루트비히 비트겐슈타인",
            publisher = "책세상",
            publicationAt = "2019-04-05",
            isbn = "9791159313554",
            stockNumber = 10,
            imagePath = "",
        )
        val json = jacksonObjectMapper().writeValueAsString(bookRequest)

        mockMvc.perform(post("/api/v1/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk)
            .andDo(print())

        val book = bookRepository.findByTitle("철학적 탐구")

        //TODO: 데이터가 같은지 확인하기 - assert가 안나와서 못작성함
    }

    @DisplayName("도서등록 - 입력값 에러")
    @Test
    fun createFailTest() {
        val bookRequest = BookRequest(
            title = "철학적 탐구",
            author = "루트비히 비트겐슈타인",
            publisher = "",
            publicationAt = "2019-04-05",
            isbn = "9791159313554",
            stockNumber = -1,
            imagePath = "",
        )
        val json = jacksonObjectMapper().writeValueAsString(bookRequest)

        mockMvc.perform(post("/api/v1/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk)
            .andExpect(
                jsonPath("\$.code").value(403)
            )
            .andDo(print())

        val book = bookRepository.findByTitle("철학적 탐구")
    }


}