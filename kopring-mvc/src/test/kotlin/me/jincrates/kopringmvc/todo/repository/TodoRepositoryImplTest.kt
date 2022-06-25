package me.jincrates.kopringmvc.todo.repository

import me.jincrates.kopringmvc.todo.config.AppConfig
import me.jincrates.kopringmvc.todo.database.Todo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

//필요한 것만 넣어줘야 효율적으로 테스트가 가능하다.
@SpringBootTest(classes = [TodoRepositoryImpl::class, AppConfig::class])
class TodoRepositoryImplTest {

    @Autowired
    lateinit var todoRepositoryImpl: TodoRepositoryImpl

    @Test
    fun saveTest() {
        val todo = Todo().apply {
            this.title = "테스트 일정"
            this.description = "테스트 설명"
            this.schedule = LocalDateTime.now()
        }

        val result = todoRepositoryImpl.save(todo)

        Assertions.assertEquals(1, result.index)
        Assertions.assertEquals("테스트 일정", result.title)
        Assertions.assertEquals("테스트 설명", result.description)
        Assertions.assertNotNull(result.createdAt)
        Assertions.assertNotNull(result.updatedAt)
    }

    @Test
    fun saveAllTest() {
        val todoList = mutableListOf(
            Todo().apply {
                this.title = "테스트 일정1"
                this.description = "테스트 설명1"
                this.schedule = LocalDateTime.now()
            },
            Todo().apply {
                this.title = "테스트 일정2"
                this.description = "테스트 설명2"
                this.schedule = LocalDateTime.now()
            },
            Todo().apply {
                this.title = "테스트 일정3"
                this.description = "테스트 설명3"
                this.schedule = LocalDateTime.now()
            }
        )

        val result = todoRepositoryImpl.saveAll(todoList)

        Assertions.assertEquals(true, result)
    }
}