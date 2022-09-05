package me.jincrates.kotlin200forbeginners.part02.ex065_upcasting;

/*
065. 업캐스팅(Upcasting)
캐스팅(Casting) 또는 형변환이란, 특정 타입을 다른 타입으로 변환하는 것을 뜻한다.
코틀린에서는 서브클래스의 인스턴스를 슈퍼클래스 타입으로 가리킬 수 있다.

서브클래스의 인스턴스를 슈퍼클래스 타입으로 가리키는 것을 업캐스팅이라고 부른다.
슈퍼클래스 타입은 항상 슈퍼 클래스 자체나 서브클래스의 인스턴스만 가리킬 수 있다.
 */
open class Person(val name: String, val age: Int)

class Student(name: String, age: Int, val id: Int): Person(name, age)

fun main(args:Array<String>): Unit {

    val person: Person = Student("John", 32, 20171218)
}