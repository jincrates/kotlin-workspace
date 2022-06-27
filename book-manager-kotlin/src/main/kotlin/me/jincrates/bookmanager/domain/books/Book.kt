package me.jincrates.bookmanager.domain.books

import me.jincrates.bookmanager.common.annotation.StringFormatDateTime
import me.jincrates.bookmanager.domain.BaseEntity
import me.jincrates.bookmanager.web.http.BookDto
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Table(name = "book")
@Entity
data class Book(
    //TODO validation 나중에 작성하자
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?= null,
    var title: String?= null,
    var author: String?= null,
    var publisher: String?= null,

    @field: StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "yyyy-MM-dd HH:mm:ss 포맷이 맞지 않습니다.")
    var publicationDate: String?= null,

    var isbn: String?= null,
    var imagePath: String?= null,
    var quantity: Int?= null

) : BaseEntity()

// 코틀린 확장 함수
fun Book.convertToEntity(dto: BookDto): Book {
    return Book().apply {
        this.id = dto.id
        this.title = dto.title
        this.author = dto.author
        this.publisher = dto.publisher
        this.publicationDate = dto.publicationDate
        this.isbn = dto.isbn
        this.imagePath = dto.imagePath
        this.quantity = dto.quantity
//        this.createdAt = LocalDateTime.parse(dto.createdAt.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
//        this.updatedAt = LocalDateTime.parse(dto.updatedAt.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
//        this.createdBy = dto.createdBy.toString()
//        this.updatedBy = dto.updatedBy.toString()
    }
}