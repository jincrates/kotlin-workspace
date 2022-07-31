package me.jincrates.bookmanager.model

import com.fasterxml.jackson.annotation.JsonFormat
import me.jincrates.bookmanager.domain.Book
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

data class BookRequest(
    @field: NotBlank(message = "제목을 입력하지 않았습니다.")
    val title: String,

    @field: NotBlank(message = "저자를 입력하지 않았습니다.")
    val author: String,

    @field: NotBlank(message = "출판사를 입력하지 않았습니다.")
    val publisher: String,

    @field: JsonFormat(pattern = "yyyy-MM-dd")
    val publicationAt: String,

    @field: NotBlank(message = "ISBN을 입력하지 않았습니다.")
    val isbn: String,

    @field: NotNull(message = "수량을 입력하지 않았습니다.")
    @field: PositiveOrZero(message = "수량은 0 이상이어야 합니다.")  // 양수 또는 0이어야 합니다.
    val stockNumber: Int,

    val imagePath: String? = null,
)

data class BookResponse(
    val id: Long,
    val title: String,
    val author: String,
    val publisher: String,
    val publicationAt: String,
    val isbn: String,
    val stockNumber: Int,
    val imagePath: String? = null,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime?,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val updatedAt: LocalDateTime?,
)

fun Book.toResponse() = BookResponse(
    id = id!!,
    title = title,
    author = author,
    publisher = publisher,
    publicationAt = publicationAt,
    isbn = isbn,
    stockNumber = stockNumber,
    imagePath = imagePath,
    createdAt = createdAt,
    updatedAt = updatedAt
)