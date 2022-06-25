package me.jincrates.kopringmvc.todo.database

data class TodoDatabase(
    var index: Int = 0,
    var todoLists: MutableList<Todo> = mutableListOf()
) {
    fun init() {
        this.todoLists = mutableListOf()
        println("[DEBUG] todo database init")
    }
}
