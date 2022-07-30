package me.jincrates.issueservicekotlin.web

import jincrates.issueservicekotlin.config.AuthUser
import me.jincrates.issueservicekotlin.model.IssueRequest
import me.jincrates.issueservicekotlin.service.IssueService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/issues")
class IssueController(
    private val issueService: IssueService
) {

    @PostMapping()
    fun create(
        //authUser: AuthUser,  //어노테이션 없이도 HandlerMethodArgumentResolver 덕분에 데이터를 가져올 수 있다.
        @RequestBody result: IssueRequest,
    ) = issueService.create(1, result)
}