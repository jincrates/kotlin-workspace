package me.jincrates.issueservicekotlin.domain

import org.springframework.data.jpa.repository.JpaRepository

interface IssueRepository : JpaRepository<Issue, Long> {
}