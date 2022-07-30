package me.jincrates.issueservicekotlin.domain

import me.jincrates.issueservicekotlin.domain.enums.IssuePriority
import me.jincrates.issueservicekotlin.domain.enums.IssueStatus
import me.jincrates.issueservicekotlin.domain.enums.IssueType
import javax.persistence.*

@Entity
@Table(name = "issue")
class Issue(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    //TODO: var val 차이
    @Column
    var userId: Long,

    @Column
    var summary: String,

    @Column
    var description: String,

    @Column
    @Enumerated(EnumType.STRING)
    var type: IssueType,

    @Column
    @Enumerated(EnumType.STRING)
    var priority: IssuePriority,

    @Column
    @Enumerated(EnumType.STRING)
    var status: IssueStatus,

    ) : BaseEntity()