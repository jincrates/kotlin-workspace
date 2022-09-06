package me.jincrates.kotlin200forbeginners.part02.ex080_is_operator;

import me.jincrates.kotlin200forbeginners.part02.ex064_inheritance.Person
import me.jincrates.kotlin200forbeginners.part02.ex064_inheritance.Student

/*
080. is 연산자
is 연산자로 참조 변수가 실제로 가리키고 있는 객체의 타입을 알아낼 수 있다.
코틀린의 is 연산자는 자바의 instanceof에 해당한다.
 */
class Professor(name: String, age: Int): Person(name, age)

fun main(args:Array<String>): Unit {

    val person: Person = Student("Mark Zuckerberg", 33, 20171225)
    print("${person is Person} ")
    print("${person is Student} ")
    print("${person is Professor} ")

    val person2: Person = Professor("Lee", 48)
    print("${person2 is Person} ")
    print("${person2 is Student} ")
    print("${person2 !is Professor} ")
}