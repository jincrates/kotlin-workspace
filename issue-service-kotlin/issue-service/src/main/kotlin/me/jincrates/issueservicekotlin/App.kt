package me.jincrates.issueservicekotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IssueServiceKotlinApplication

fun main(args: Array<String>) {
	runApplication<IssueServiceKotlinApplication>(*args)
}
