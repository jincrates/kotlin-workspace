package me.jincrates.bookmanager.domain.books

import me.jincrates.bookmanager.common.annotation.StringFormatDateTime
import me.jincrates.bookmanager.domain.BaseEntity
import me.jincrates.bookmanager.web.http.BookDto
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

@Table(name = "book")
@Entity
data class Book(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?= null,

    @field: NotBlank(message = "제목을 입력하지 않았습니다.")
    var title: String?= null,

    @field: NotBlank(message = "저자를 입력하지 않았습니다.")
    var author: String?= null,

    @field: NotBlank(message = "출판사를 입력하지 않았습니다.")
    var publisher: String?= null,

    @field: StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "yyyy-MM-dd HH:mm:ss 포맷이 맞지 않습니다.")
    var publicationDate: String?= null,

    @field: NotBlank(message = "ISBN을 입력하지 않았습니다.")
    var isbn: String?= null,

    var imagePath: String?= null,

    @field: NotNull(message = "수량을 입력하지 않았습니다.")
    @field: PositiveOrZero(message = "수량은 0 이상이어야 합니다.")  // 양수 또는 0이어야 합니다.
    var quantity: Int?= null

) : BaseEntity()

// 코틀린 확장 함수
fun toEntity(dto: BookDto): Book {
    return Book().apply {
        this.id = dto.id
        this.title = dto.title
        this.author = dto.author
        this.publisher = dto.publisher
        this.publicationDate = dto.publicationDate
        this.isbn = dto.isbn
        this.imagePath = dto.imagePath
        this.quantity = dto.quantity
    }
}