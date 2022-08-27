package me.jincrates.issueservice.domain

import me.jincrates.issueservice.domain.enums.IssuePriority
import me.jincrates.issueservice.domain.enums.IssueStatus
import me.jincrates.issueservice.domain.enums.IssueType
import javax.persistence.*

@Entity
@Table(name = "issue")
class Issue(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    //TODO: var val 차이
    @Column
    var userId: Long,

    //이슈 하나에 여러개의 코멘트 등록이 가능하기 때문
    @OneToMany(fetch = FetchType.EAGER)
    val comments: MutableList<Comment> = mutableListOf(),

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