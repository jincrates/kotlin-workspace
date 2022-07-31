package me.jincrates.bookmanager.domain

import javax.persistence.*

@Table(name = "book")
@Entity
data class Book(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    val id: Long? = null,

    @Column
    var title: String,

    @Column
    var author: String,

    @Column
    var publisher: String,

    @Column
    var publicationAt: String,

    @Column
    var isbn: String,

    @Column
    var stockNumber: Int,

    @Column
    var imagePath: String? = null,

) : BaseEntity()
