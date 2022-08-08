package me.jincrates.kopringmvc.todo.config

import me.jincrates.kopringmvc.todo.database.TodoDatabase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean(initMethod = "init")
    fun todoDataBase(): TodoDatabase {
        return TodoDatabase()
    }
}