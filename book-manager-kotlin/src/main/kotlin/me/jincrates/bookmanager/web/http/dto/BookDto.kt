package me.jincrates.bookmanager.web.http.dto

import com.fasterxml.jackson.annotation.JsonProperty
import me.jincrates.bookmanager.common.annotation.StringFormatDateTime
import me.jincrates.bookmanager.domain.books.Book
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

class BookDto(

    var id: Long? = null,

    @field: NotBlank(message = "제목을 입력하지 않았습니다.")
    var title: String? = null,

    @field: NotBlank(message = "저자를 입력하지 않았습니다.")
    var author: String? = null,

    @field: NotBlank(message = "출판사를 입력하지 않았습니다.")
    var publisher: String? = null,

    @JsonProperty("publication_date")
    @field: StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "yyyy-MM-dd HH:mm:ss 포맷이 맞지 않습니다.")
    var publicationDate: String? = null,

    @field: NotBlank(message = "ISBN을 입력하지 않았습니다.")
    var isbn: String? = null,

    @JsonProperty("image_path")
    var imagePath: String? = null,

    @JsonProperty("stock_number")
    @field: NotNull(message = "수량을 입력하지 않았습니다.")
    @field: PositiveOrZero(message = "수량은 0 이상이어야 합니다.")  // 양수 또는 0이어야 합니다.
    var stockNumber: Int? = null,
) {
    // 코틀린 확장 함수
    fun of(entity: Book): BookDto {
        return BookDto().apply {
            this.id = entity.id
            this.title = entity.title
            this.author = entity.author
            this.publisher = entity.publisher
            this.publicationDate = entity.publicationDate
            this.isbn = entity.isbn
            this.imagePath = entity.imagePath
            this.stockNumber = entity.stockNumber
        }
    }

    fun toEntity(dto: BookDto): Book {
        return Book().apply {
            this.id = dto.id
            this.title = dto.title
            this.author = dto.author
            this.publisher = dto.publisher
            this.publicationDate = dto.publicationDate
            this.isbn = dto.isbn
            this.imagePath = dto.imagePath
            this.stockNumber = dto.stockNumber
        }
    }

}

