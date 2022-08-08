package me.jincrates.kopringmvc.todo.domain.model.http

import io.swagger.annotations.ApiModelProperty
import me.jincrates.kopringmvc.todo.database.Todo
import me.jincrates.kopringmvc.todo.domain.annotation.StringFormatDateTime
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.NotBlank

data class TodoDto(

    @field: ApiModelProperty(
        value = "DB INDEX",
        example = "1",
        required =  false
    )
    var index: Int ?= null,

    @field: ApiModelProperty(
        value = "일정명",
        example = "일정관리",
        required =  true
    )
    @field: NotBlank
    var title: String ?= null,

    @field: ApiModelProperty(
        value = "일정설명",
        example = "13시 스타벅스",
        required =  true
    )
    var description: String ?= null,

    @field: ApiModelProperty(
        value = "일정시간",
        example = "2022-01-01 12:00:00",
        required =  true
    )
    @field: NotBlank
    @field: StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "yyyy-MM-dd HH:mm:ss 포맷이 맞지 않습니다.")
    var schedule: String ?= null,  // yyyy-MM-dd HH:mm:ss

    @field: ApiModelProperty(
        value = "생성일자",
        required = false
    )
    var createdAt: LocalDateTime ?= null,

    @field: ApiModelProperty(
        value = "수정일자",
        required =  false
    )
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
