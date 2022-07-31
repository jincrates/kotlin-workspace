package me.jincrates.bookmanager.domain

import com.fasterxml.jackson.annotation.JsonFormat
import me.jincrates.bookmanager.common.annotation.StringFormatDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

@Table(name = "book")
@Entity
data class Book(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    val id: Long? = null,

    @field: NotBlank(message = "제목을 입력하지 않았습니다.")
    @Column
    var title: String,

    @field: NotBlank(message = "저자를 입력하지 않았습니다.")
    @Column
    var author: String,

    @field: NotBlank(message = "출판사를 입력하지 않았습니다.")
    @Column
    var publisher: String,

    @field: JsonFormat(pattern = "yyyy-MM-dd")
    @Column
    var publicationAt: String,

    @field: NotBlank(message = "ISBN을 입력하지 않았습니다.")
    @Column
    var isbn: String,

    @field: NotNull(message = "수량을 입력하지 않았습니다.")
    @field: PositiveOrZero(message = "수량은 0 이상이어야 합니다.")  // 양수 또는 0이어야 합니다.
    @Column
    var stockNumber: Int,

    @Column
    var imagePath: String? = null,

) : BaseEntity()
