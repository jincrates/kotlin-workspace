package me.jincrates.bookmanager.web.http

import com.fasterxml.jackson.annotation.JsonProperty
import me.jincrates.bookmanager.web.http.dto.BookDto

data class BookResponse(
    var result: Result?= null,
    var description: String ?= null,
    var book: MutableList<BookDto> ?= null
)

data class Result(
    @JsonProperty("result_code")
    var resultCode: String? = null,

    @JsonProperty("result_message")
    var resultMessage: String ?= null
)