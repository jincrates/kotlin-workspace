package me.jincrates.issueservicekotlin.service

import me.jincrates.issueservicekotlin.domain.Issue
import me.jincrates.issueservicekotlin.domain.IssueRepository
import me.jincrates.issueservicekotlin.model.IssueRequest
import me.jincrates.issueservicekotlin.model.IssueResponse
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class IssueService(
    private val issueRepository: IssueRepository,
) {

    @Transactional
    fun create(userId: Long, request: IssueRequest) : IssueResponse {

        val issue = Issue(
            summary = request.summary,
            description = request.description,
            userId = userId,
            type = request.type,
            priority = request.priority,
            status = request.status,
        )
        return IssueResponse(issueRepository.save(issue))
    }
}