package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex094_extension_funtion_companion_object;

/*
094. 동반자 객체의 확장 함수
동반자 객체는 클래스 이름만으로 접근할 수 있지만, 확장 함수를 선언할 때 그렇게 하면
동반자 객체가 아닌 클래스 자체에 멤버 함수가 추가되므로 Companion 식별자를 반드시 적어줘야 한다.
 */
class Person { companion object }

fun Person.Companion.create() = Person()

fun main(args:Array<String>) = Person.create()