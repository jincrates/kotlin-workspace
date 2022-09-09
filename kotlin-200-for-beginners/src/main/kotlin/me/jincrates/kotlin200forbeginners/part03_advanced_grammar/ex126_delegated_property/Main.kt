package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex126_delegated_property;

/*
126. 위임된 프로퍼티(Delegated Property)
프로그램을 작성하다 보면 Int 타입의 프로퍼티에 음수가 저장되는 것을 방지하는 Setter를 정의할 때가 자주있다.

var age: Int set(value) if (value > 0) field = value
var salary: Int set(value) if (value > 0) field = value

그러나 이렇게 모든 프로퍼티의 Setter를 일일이 정의하는 것은 너무 번거롭다.

코틀린에서는 이런 상황을 위해 프로퍼티의 Getter/Setter 구현을 다른 객체에 맡길 수 있는 문법을 제공한다.
프로퍼티 선언 문에 by 객체를 적으면 해당 객체가 프로퍼티의 Getter/Setter를 대리하게 된다.
 */
fun main(args:Array<String>): Unit {

    val sample = Sample()

    sample.number = -50
    println(sample.number)

    sample.number = 100
    println(sample.number)
}