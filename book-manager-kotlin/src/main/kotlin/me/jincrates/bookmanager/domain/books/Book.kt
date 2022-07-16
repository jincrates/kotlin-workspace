package me.jincrates.bookmanager.domain.books

import me.jincrates.bookmanager.common.annotation.StringFormatDateTime
import me.jincrates.bookmanager.domain.BaseEntity
import me.jincrates.bookmanager.web.http.dto.BookDto
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

@Table(name = "book")
@Entity
data class Book(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private var id: Long? = null,

    @field: NotBlank(message = "제목을 입력하지 않았습니다.")
    private var title: String? = null,

    @field: NotBlank(message = "저자를 입력하지 않았습니다.")
    private var author: String? = null,

    @field: NotBlank(message = "출판사를 입력하지 않았습니다.")
    private var publisher: String? = null,

    @field: StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "yyyy-MM-dd HH:mm:ss 포맷이 맞지 않습니다.")
    private var publicationDate: String? = null,

    @field: NotBlank(message = "ISBN을 입력하지 않았습니다.")
    private var isbn: String? = null,

    private var imagePath: String? = null,

    @field: NotNull(message = "수량을 입력하지 않았습니다.")
    @field: PositiveOrZero(message = "수량은 0 이상이어야 합니다.")  // 양수 또는 0이어야 합니다.
    private var stockNumber: Int? = null,
) : BaseEntity() {

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

    fun updateBook(dto: BookDto) {
        this.title = dto.title
        this.author = dto.author
        this.publisher = dto.publisher
        this.publicationDate = dto.publicationDate
        this.isbn = dto.isbn
        this.imagePath = dto.imagePath
        this.stockNumber = dto.stockNumber
    }

    fun addStock(stackNumber: Int) {
        this.stockNumber = this.stockNumber?.plus(stackNumber);
    }

    fun removeStock(stackNumber: Int) {
        val restStock: Int? = this.stockNumber?.minus(stackNumber);
        if (restStock != null) {
            if (restStock < 0) {
                throw RuntimeException("도서의 재고수량이 부족합니다. (현재 도서 수량: " + this.stockNumber + ")")
            }
            this.stockNumber = restStock
        }
    }
}


