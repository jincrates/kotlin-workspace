package me.jincrates.kotlinindepth.chapter04

//4.1.2 생성자
class Person2(firstName: String, familyName: String) {
    val fullName = "$firstName $familyName"

    init {
        println("Created new Person instance: $fullName")
    }
}

fun main() {
    val person = Person2("길동", "홍")
    println(person.fullName)
}