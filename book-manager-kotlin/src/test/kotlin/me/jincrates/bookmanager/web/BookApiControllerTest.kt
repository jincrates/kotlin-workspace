package me.jincrates.bookmanager.web

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
@AutoConfigureMockMvc
class BookApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun readTest() {
        mockMvc.perform(
            get("/api/book")
        ).andExpect(
            status().isOk
        ).andDo(print())
    }

}