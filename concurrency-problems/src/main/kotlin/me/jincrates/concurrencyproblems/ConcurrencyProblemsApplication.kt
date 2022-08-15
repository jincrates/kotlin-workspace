package me.jincrates.concurrencyproblems

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConcurrencyProblemsApplication

fun main(args: Array<String>) {
	runApplication<ConcurrencyProblemsApplication>(*args)
}
