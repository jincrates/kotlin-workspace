package me.jincrates.bookmanager.service

import me.jincrates.bookmanager.domain.books.Book
import me.jincrates.bookmanager.domain.books.BookRepository
import me.jincrates.bookmanager.web.http.dto.BookDto
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    // C
    fun create(bookDto: BookDto): BookDto? {
        return bookDto.let {
            Book().toEntity(it)
        }.let {
            bookRepository.save(it)
        }.let {
            BookDto().of(it)
        }
    }

    // R
    fun read(id: Long): BookDto? {
        return bookRepository.findById(id).get().let {
            BookDto().of(it)
        }
    }

    fun readAll(): MutableList<BookDto> {
        return bookRepository.findAll().map {
            BookDto().of(it)
        }.toMutableList()
    }

    // U
    fun update(bookDto: BookDto): BookDto? {
        return bookDto.let {
            Book().toEntity(it)
        }.let {
            bookRepository.save(it)
        }.let {
            BookDto().of(it)
        }
    }

    // D
    fun delete(id: Long): Boolean {
        bookRepository.deleteById(id)
        //existsById(지운 id가 존재하는가)가 false면 정상적으로 지워진 것이기에 true를 리턴하도록 했다.
        return !bookRepository.existsById(id)
    }

}