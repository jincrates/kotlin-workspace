package me.jincrates.issueservicekotlin.service

import me.jincrates.issueservicekotlin.domain.Comment
import me.jincrates.issueservicekotlin.domain.CommentRepository
import me.jincrates.issueservicekotlin.domain.IssueRepository
import me.jincrates.issueservicekotlin.exception.NotFoundException
import me.jincrates.issueservicekotlin.model.CommentRequest
import me.jincrates.issueservicekotlin.model.CommentResponse
import me.jincrates.issueservicekotlin.model.toResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentService (
    private val commentRepository: CommentRepository,
    private val issueRepository: IssueRepository
) {

    @Transactional
    fun create(issueId: Long, userId: Long, username: String, request: CommentRequest) : CommentResponse {
        val issue = issueRepository.findByIdOrNull(issueId) ?: throw NotFoundException("이슈가 존재하지 않습니다")

        val comment = Comment(
            issue = issue,
            userId = userId,
            username = username,
            body = request.body,
        )

        issue.comments.add(comment)
        return commentRepository.save(comment).toResponse()
    }
}