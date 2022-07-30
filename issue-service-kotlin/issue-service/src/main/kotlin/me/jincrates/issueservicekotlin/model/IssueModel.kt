package me.jincrates.issueservicekotlin.model

import com.fasterxml.jackson.annotation.JsonFormat
import me.jincrates.issueservicekotlin.domain.Issue
import me.jincrates.issueservicekotlin.domain.enums.IssuePriority
import me.jincrates.issueservicekotlin.domain.enums.IssueStatus
import me.jincrates.issueservicekotlin.domain.enums.IssueType
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
    val summary: String,
    val description: String,
    val userId: Long,
    val type: IssueType,
    val status: IssueStatus,
    val priority: IssuePriority,
    @JsonFormat(pattern = "yyyy-MM-dd HH::mm:ss")
    val createdAt: LocalDateTime?,
    @JsonFormat(pattern = "yyyy-MM-dd HH::mm:ss")
    val updatedAt: LocalDateTime?,
) {
    companion object {

        operator fun invoke(issue: Issue) =
            with(issue) {
                IssueResponse(
                    id = this.id!!,
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