package me.jincrates.bookmanager.web

import me.jincrates.bookmanager.service.BookService
import me.jincrates.bookmanager.web.http.BookDto
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/book")
class BookApiController(
    val bookService: BookService
) {

    // R
    @GetMapping(path = [""])
    fun read(
        @RequestParam(required = false) id: Long?
    ): ResponseEntity<Any?> {
        return id?.let {
            bookService.read(it)
        }?.let {
            return ResponseEntity.ok(it)
        }?: kotlin.run {
            return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .header(HttpHeaders.LOCATION, "/api/book/all")
                .build()
        }
    }

    @GetMapping(path = ["/all"])
    fun readAll(): MutableList<BookDto> {
        return bookService.readAll()
    }

    // C
    @PostMapping("")
    fun create(@Valid @RequestBody bookDto: BookDto): BookDto? {
        return bookService.create(bookDto)
    }

    // U
    // Todo create = 201 내리고, update = 200 내리도록 변경
    @PutMapping(path = [""])
    fun update(@Valid @RequestBody bookDto: BookDto): BookDto? {
        return bookService.create(bookDto)
    }

    // D
    @DeleteMapping(path = ["/{id}"])
    fun delete(@PathVariable(name = "id") _id : Long): ResponseEntity<Any> {

        if (!bookService.delete(_id)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }

        return ResponseEntity.ok().build()
    }
}