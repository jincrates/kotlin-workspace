package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex088_object_declaration;

/*
088. 객체 선언(Object Declaration)
프로그램 전체에서 공유 가능한 유일한 객체를 만들어 보자

클래스를 선언하듯 객체를 선언하고 있다.
이렇게 하면 Person이라는 식별자로 객쳋에 바로 접근할 수 있다.

싱글톤 패턴을 대체하는 object 키워드
object 키워드 덕에 자바에서 작성해야만 했던 싱클톤 패턴 코드를 더 이상 쓰지 않아도 되게 되었다.
그저 일반 클래스를 선언하듯이, 프로그램 전체에서 단 하나만 존재하는 객체를 편하게 만들 수 있다.
 */

object Person {
    var name: String = ""
    var age: Int = 0
    fun print() {
        println(name)
        println(age)
    }
}

fun main(args:Array<String>): Unit {
    // 식별자 Person으로 객체에 바로 접근 가능
    Person.name = "Singleton"
    Person.age = 45
    Person.print()
}