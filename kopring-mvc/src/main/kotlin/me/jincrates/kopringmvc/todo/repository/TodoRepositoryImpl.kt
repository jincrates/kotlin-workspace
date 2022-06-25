package me.jincrates.kopringmvc.todo.repository

import me.jincrates.kopringmvc.todo.database.Todo
import me.jincrates.kopringmvc.todo.database.TodoDatabase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TodoRepositoryImpl: TodoRepository  {

    @Autowired
    lateinit var todoDatabase: TodoDatabase

    override fun save(todo: Todo): Todo {
        return todo.apply {
            this.index = ++todoDatabase.index
            this.createdAt = LocalDateTime.now()
            this.updatedAt = LocalDateTime.now()
        }.run {
            todoDatabase.todoList.add(todo)
            this
        }
    }

    override fun saveAll(todoList: MutableList<Todo>): Boolean {
        return try {
            todoList.forEach {
                save(it)
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun update(todo: Todo): Todo {
        TODO("Not yet implemented")
    }

    override fun delete(index: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun findOne(index: Int): Todo {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<Todo> {
        TODO("Not yet implemented")
    }
}