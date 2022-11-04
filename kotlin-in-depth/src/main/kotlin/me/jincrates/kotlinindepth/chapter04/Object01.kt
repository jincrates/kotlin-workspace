package me.jincrates.kotlinindepth.chapter04

class Person {
    var firstName: String = ""
    var familyName: String = ""
    var age: Int = 0

    fun fullName() = "$familyName $firstName"

    fun showMe() {
        println("${fullName()}: $age")
    }
}


fun main() {
    val person = Person()  //Person 인스턴스 생성

    person.familyName = "홍"
    person.firstName = "길동"
    person.age = 29

    person.showMe()
}
