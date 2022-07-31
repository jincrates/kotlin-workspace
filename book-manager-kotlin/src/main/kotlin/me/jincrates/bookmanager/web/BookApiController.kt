package me.jincrates.bookmanager.web

import me.jincrates.bookmanager.config.AuthUser
import me.jincrates.bookmanager.model.BookRequest
import me.jincrates.bookmanager.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/books")
class BookApiController(
    private val bookService: BookService
) {

    //TODO: 유효성 추가
    @PostMapping()
    fun create(
        authUser: AuthUser,
        @Valid @RequestBody request: BookRequest,
    ) = bookService.create(authUser.userId, request)

    @GetMapping()
    fun getAll(
        authUser: AuthUser,
    ) = bookService.getAll()

    @GetMapping("/{bookId}")
    fun get(
        authUser: AuthUser,
        @PathVariable bookId: Long,
    ) = bookService.get(bookId)

    @PutMapping("/{bookId}")
    fun edit(
        authUser: AuthUser,
        @PathVariable bookId: Long,
        @Valid @RequestBody request: BookRequest,
    ) = bookService.edit(bookId, request) //삭제는 다른 인원도 가능하도록 userId를 넘기지 않음

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        authUser: AuthUser,
        @PathVariable bookId: Long,
    ) = bookService.delete(bookId) //삭제는 다른 인원도 가능하도록 userId를 넘기지 않음
}