package me.jincrates.kopringmvc.todo.service

import me.jincrates.kopringmvc.todo.database.Todo
import me.jincrates.kopringmvc.todo.database.convertTodo
import me.jincrates.kopringmvc.todo.domain.model.http.TodoDto
import me.jincrates.kopringmvc.todo.domain.model.http.convertTodoDto
import me.jincrates.kopringmvc.todo.repository.TodoRepositoryImpl
import org.springframework.stereotype.Service

/*
* java: model mapper
* kotlin: reflection
*/

@Service
class TodoService(
    val todoRepositoryImpl: TodoRepositoryImpl
) {
    // C
    fun create(todoDto: TodoDto): TodoDto? {
        return todoDto.let {
            Todo().convertTodo(it)
        }.let {
            todoRepositoryImpl.save(it)
        }?.let {
            TodoDto().convertTodoDto(it)
        }
    }

    // R
    fun read(index: Int): TodoDto? {
        return todoRepositoryImpl.findOne(index)
            ?.let {
                TodoDto().convertTodoDto(it)
            }
    }

    fun readAll(): MutableList<TodoDto> {
        return todoRepositoryImpl.findAll()
            .map {
                TodoDto().convertTodoDto(it)
            }.toMutableList()
    }

    // U
    fun update(todoDto: TodoDto): TodoDto? {
        return todoDto.let {
            Todo().convertTodo(it)
        }.let {
            todoRepositoryImpl.save(it)
        }?.let {
            TodoDto().convertTodoDto(it)
        }
    }

    // D
    fun delete(index: Int): Boolean {
        return todoRepositoryImpl.delete(index)
    }
}