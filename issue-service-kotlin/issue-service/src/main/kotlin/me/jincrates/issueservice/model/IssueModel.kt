package me.jincrates.issueservice.model

import com.fasterxml.jackson.annotation.JsonFormat
import me.jincrates.issueservice.domain.Comment
import me.jincrates.issueservice.domain.Issue
import me.jincrates.issueservice.domain.enums.IssuePriority
import me.jincrates.issueservice.domain.enums.IssueStatus
import me.jincrates.issueservice.domain.enums.IssueType
import java.time.LocalDateTime

data class IssueRequest(
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,
)

data class IssueResponse(
    val id: Long,
    val comments: List<CommentResponse> = emptyList(),
    val summary: String,
    val description: String,
    val userId: Long,
    val type: IssueType,
    val status: IssueStatus,
    val priority: IssuePriority,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime?,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val updatedAt: LocalDateTime?,
) {
    companion object {

        operator fun invoke(issue: Issue) =
            with(issue) {
                IssueResponse(
                    id = this.id!!,
                    comments = comments.sortedByDescending(Comment::id).map(Comment::toResponse),
                    summary = this.summary,
                    description = this.description,
                    userId = this.userId,
                    type = this.type,
                    status = this.status,
                    priority = this.priority,
                    createdAt = this.createdAt,
                    updatedAt = this.updatedAt
                )
            }
    }
}