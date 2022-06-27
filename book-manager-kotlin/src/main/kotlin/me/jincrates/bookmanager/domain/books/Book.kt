package me.jincrates.bookmanager.domain.books

import me.jincrates.bookmanager.common.annotation.StringFormatDateTime
import me.jincrates.bookmanager.domain.BaseEntity
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Table(name = "book")
@Entity
data class Book(

    //TODO validation 나중에 작성하자
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int ?= null,
    var title: String ?= null,
    var author: String ?= null,
    var publisher: String ?= null,

    @field: StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "yyyy-MM-dd HH:mm:ss 포맷이 맞지 않습니다.")
    var publicationDate: String ?= null,

    var isbn: String ?= null,
    var imagePath: String ?= null,
    var quantity: Int ?= null

) : BaseEntity()
