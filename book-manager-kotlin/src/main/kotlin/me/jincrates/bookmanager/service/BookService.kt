package me.jincrates.bookmanager.service

import me.jincrates.bookmanager.domain.book.Book
import me.jincrates.bookmanager.repository.BookRepository
import me.jincrates.bookmanager.exception.NotFoundException
import me.jincrates.bookmanager.model.BookRequest
import me.jincrates.bookmanager.model.BookResponse
import me.jincrates.bookmanager.model.toResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    @Transactional
    fun create(userId: Long, request: BookRequest): BookResponse {
        val book = Book(
            title = request.title,
            author = request.author,
            publisher = request.publisher,
            publicationAt = request.publicationAt,
            isbn = request.isbn,
            stockNumber = request.stockNumber,
            imagePath = request.imagePath,
        )
        return bookRepository.save(book).toResponse()
    }

    @Transactional(readOnly = true)
    fun getAll() =
        bookRepository.findAllByOrderByCreatedAtDesc()
            ?.map { it.toResponse() }  // map을 통해 Book을 BookResponse로 변환

    @Transactional(readOnly = true)
    fun get(bookId: Long): BookResponse {
        val book = bookRepository.findByIdOrNull(bookId) ?: throw NotFoundException("도서가 존재하지 않습니다")
        return book.toResponse()
    }

    @Transactional
    fun edit(bookId: Long, request: BookRequest): BookResponse {
        val book = bookRepository.findByIdOrNull(bookId) ?: throw NotFoundException("도서가 존재하지 않습니다")
        return with(book) {
            title = request.title
            author = request.author
            publisher = request.publisher
            publicationAt = request.publicationAt
            isbn = request.isbn
            stockNumber = request.stockNumber
            imagePath = request.imagePath
            bookRepository.save(this).toResponse()
        }
    }

    fun delete(bookId: Long) {
        val book = bookRepository.findByIdOrNull(bookId) ?: throw NotFoundException("도서가 존재하지 않습니다")
        bookRepository.delete(book)
    }
}