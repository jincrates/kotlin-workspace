package me.jincrates.kopringmvc.todo.controller.api.todo

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import me.jincrates.kopringmvc.todo.domain.model.http.TodoDto
import me.jincrates.kopringmvc.todo.service.TodoService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@Api(description = "일정관리")
@RestController
@RequestMapping("/api/todo")
class TodoApiController(
    val todoService: TodoService
) {

    // R
    @ApiOperation(value = "일정 찾기", notes = "일정 찾기 GET")
    @GetMapping(path = [""])
    fun read(
        @ApiParam(name = "index")
        @PathVariable(required = false) index: Int?
    ): ResponseEntity<Any?> {

        return index?.let {
            todoService.read(it)
        }?.let {
            return ResponseEntity.ok(it)
        }?: kotlin.run {
            return ResponseEntity
                    .status(HttpStatus.MOVED_PERMANENTLY)
                    .header(HttpHeaders.LOCATION, "/api/todo/all")
                    .build()
        }

    }

    @ApiOperation(value = "전체 일정 찾기", notes = "전체 일정 찾기 GET")
    @GetMapping(path = ["/all"])
    fun readAll(): MutableList<TodoDto> {
        return todoService.readAll()
    }

    // C
    @ApiOperation(value = "일정 생성", notes = "일정 생성 POST")
    @PostMapping(path = [""])  // return ResponseEntity
    fun create(@Valid @RequestBody todoDto: TodoDto): TodoDto? {
        return todoService.create(todoDto)
    }

    // U TODO create = 201 내리도록, update = 200 내리도록 변경
    @ApiOperation(value = "일정 업데이트", notes = "일정 업데이트 PUT")
    @PutMapping(path = [""])
    fun update(@Valid @RequestBody todoDto: TodoDto): TodoDto? {
        return todoService.create(todoDto)
    }

    // D
    @ApiOperation(value = "일정 삭제", notes = "일정 삭제 DELETE")
    @DeleteMapping(path = ["/{index}"])
    fun delete(@PathVariable(name = "index") _index: Int): ResponseEntity<Any> {

        if (!todoService.delete(_index)) {
            return ResponseEntity.status(500).build()
        }

        return ResponseEntity.ok().build()
    }
}