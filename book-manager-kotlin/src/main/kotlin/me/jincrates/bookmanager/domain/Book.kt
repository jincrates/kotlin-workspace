package me.jincrates.bookmanager.domain

import javax.persistence.*

@Table(name = "book")
@Entity
data class Book(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    val id: Long? = null,
    var title: String,
    var author: String,
    var publisher: String,
    var publicationAt: String,
    var isbn: String,
    var stockNumber: Int,
    var imagePath: String? = null,

) : BaseEntity()
