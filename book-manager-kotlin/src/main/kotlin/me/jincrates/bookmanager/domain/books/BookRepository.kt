package me.jincrates.bookmanager.domain.books

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface BookRepository : JpaRepository<Book, Long> {
}