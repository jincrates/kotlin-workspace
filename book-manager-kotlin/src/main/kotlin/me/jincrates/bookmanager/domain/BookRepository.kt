package me.jincrates.bookmanager.domain

import me.jincrates.bookmanager.domain.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> {

    fun findByTitle(title: String): Book?

    fun findAllByOrderByCreatedAtDesc(): List<Book>?
}