package me.jincrates.bookmanager.web.http

import com.fasterxml.jackson.annotation.JsonProperty
import me.jincrates.bookmanager.common.annotation.StringFormatDateTime
import me.jincrates.bookmanager.domain.books.Book
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

class BookDto(

    var id: Long?= null,

    @field: NotBlank(message = "제목을 입력하지 않았습니다.")
    var title: String?= null,

    @field: NotBlank(message = "저자를 입력하지 않았습니다.")
    var author: String?= null,

    @field: NotBlank(message = "출판사를 입력하지 않았습니다.")
    var publisher: String?= null,

    @JsonProperty("publication_date")
    @field: StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "yyyy-MM-dd HH:mm:ss 포맷이 맞지 않습니다.")
    var publicationDate: String?= null,

    @field: NotBlank(message = "ISBN을 입력하지 않았습니다.")
    var isbn: String?= null,

    @JsonProperty("image_path")
    var imagePath: String?= null,

    @field: NotNull(message = "수량을 입력하지 않았습니다.")
    @field: PositiveOrZero(message = "수량은 0 이상이어야 합니다.")  // 양수 또는 0이어야 합니다.
    var quantity: Int?= null,

//    var createdAt: LocalDateTime?= null,
//    var updatedAt: LocalDateTime?= null,
//    var createdBy: String?= null,
//    var updatedBy: String?= null
)

// 코틀린 확장 함수
fun BookDto.convertToDto(entity: Book): BookDto {
    return BookDto().apply {
        this.id = entity.id
        this.title = entity.title
        this.author = entity.author
        this.publisher = entity.publisher
        this.publicationDate = entity.publicationDate
        this.isbn = entity.isbn
        this.imagePath = entity.imagePath
        this.quantity = entity.quantity
//        this.createdAt = entity.createdAt
//        this.updatedAt = entity.updatedAt
//        this.createdBy = entity.createdBy
//        this.updatedBy = entity.updatedBy
    }
}
