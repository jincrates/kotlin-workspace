package me.jincrates.kotlin200forbeginners.part03.ex095_extension_function_inherit_relation;

/*
095. 확장 함수의 리시버 타입이 상속 관계에 있을 때

여기서 AAA.hello()가 호출될까? BBB.hello()가 호출될까?
확장 함수는 멤버 함수와는 다르게 참조 변수가 실제로 가리키는 객체의 타입을 따르지 않고,
참조 변수의 타입을 그대로 따른다.
멤버 함수와 확장 함수의 동작이 같지 않다는 것을 염두하길 바란다.
 */
open class AAA; class BBB: AAA()

fun AAA.hello() = println("AAA")
fun BBB.hello() = println("BBB")

fun main(args:Array<String>): Unit {
    val test: AAA = BBB()
    test.hello()
}