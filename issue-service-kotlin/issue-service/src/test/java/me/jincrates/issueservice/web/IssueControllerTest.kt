package me.jincrates.issueservice.web

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import me.jincrates.issueservice.domain.enums.IssuePriority
import me.jincrates.issueservice.domain.enums.IssueStatus
import me.jincrates.issueservice.domain.enums.IssueType
import me.jincrates.issueservice.model.IssueRequest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest
@AutoConfigureMockMvc
class IssueControllerTest{
    @Autowired lateinit var mockMvc : MockMvc

    @DisplayName("이슈 등록 - 정상")
    @Test
    fun createSuccessTest() {
        val issueRequest = IssueRequest(
            summary = "테스트",
            description = "테스트 내용",
            type = IssueType.TASK,
            priority = IssuePriority.LOW,
            status = IssueStatus.TODO
        )

        val json = jacksonObjectMapper().writeValueAsString(issueRequest)
        println(json)

        mockMvc.perform(
            post("/api/v1/issues")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(print())
    }
}