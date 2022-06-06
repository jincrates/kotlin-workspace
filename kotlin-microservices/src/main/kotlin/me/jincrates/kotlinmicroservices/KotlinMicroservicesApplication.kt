package me.jincrates.kotlinmicroservices

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinMicroservicesApplication

fun main(args: Array<String>) {
	runApplication<KotlinMicroservicesApplication>(*args)
}
