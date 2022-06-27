package me.jincrates.bookmanager.service

import me.jincrates.bookmanager.domain.books.Book
import me.jincrates.bookmanager.domain.books.BookRepository
import me.jincrates.bookmanager.domain.books.convertToEntity
import me.jincrates.bookmanager.web.http.BookDto
import me.jincrates.bookmanager.web.http.convertToDto
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {

    // C
    fun create(bookDto: BookDto): BookDto? {
        return bookDto.let {
            Book().convertToEntity(it)
        }.let {
            bookRepository.save(it)
        }.let {
            BookDto().convertToDto(it)
        }
    }

    // R
    fun read(id: Long): BookDto? {
        return bookRepository.findById(id).get().let {
            BookDto().convertToDto(it)
        }
    }

    fun readAll(): MutableList<BookDto> {
        return bookRepository.findAll().map {
            BookDto().convertToDto(it)
        }.toMutableList()
    }

    // U
    fun update(bookDto: BookDto): BookDto? {
        return bookDto.let {
            Book().convertToEntity(it)
        }.let {
            bookRepository.save(it)
        }.let {
            BookDto().convertToDto(it)
        }
    }

    // D
    fun delete(id: Long) {
        return bookRepository.deleteById(id)
    }

}