package me.jincrates.kopringmvc.todo.model.http

import me.jincrates.kopringmvc.todo.annotation.StringFormatDateTime
import java.time.LocalDateTime
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotBlank

data class TodoDto(

    var index: Int ?= null,

    @field: NotBlank
    var title: String ?= null,

    var description: String ?= null,

    @field: NotBlank
    @field: StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "yyyy-MM-dd HH:mm:ss 포맷이 맞지 않습니다.")
    var schedule: String ?= null,  // yyyy-MM-dd HH:mm:ss

    var createdAt: LocalDateTime ?= null,

    var updatedAt: LocalDateTime ?= null
)