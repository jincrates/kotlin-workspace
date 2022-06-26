package me.jincrates.kopringmvc.todo.domain.model.http

import me.jincrates.kopringmvc.todo.database.Todo
import me.jincrates.kopringmvc.todo.domain.annotation.StringFormatDateTime
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
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

//코틀린 확장 함수
fun TodoDto.convertTodoDto(todo: Todo): TodoDto {
    return TodoDto().apply {
        this.index = todo.index
        this.title = todo.title
        this.description = todo.description
        this.schedule = todo.schedule?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        this.createdAt = todo.createdAt
        this.updatedAt = todo.updatedAt
    }
}
