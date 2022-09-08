package me.jincrates.kotlin200forbeginners.part03.ex106_function_reference;

/*
106. 함수 참조(Function Reference)
함수 타입의 변수는 이미 선언되어 있는 함수나 객체의 멤버 함수를 가리킬 수도 있다.

함수 이름 앞에 ::를 붙이면, 표현식의 값은 그 함수의 참조값이 되며, 타입은 그 함수의 시그니처에 맞는 함수 타입이 된다.
::plus는 (Int, Int) -> Unit 타입의 표현식이 된다.
 */
fun plus(a: Int, b: Int) = println("plus 호출됨 ${a + b}")

object Object {
    fun minus(a: Int, b: Int) = println("Object의 minus 호출됨 ${a - b}")
}

class Class {
    fun average(a: Int, b: Int) = println("Class average 호출됨 ${(a + b) / 2}")
}

fun main(args:Array<String>): Unit {

    var instantFunc: (Int, Int) -> Unit
    instantFunc = ::plus
    instantFunc(60, 27)

    instantFunc = Object::minus
    instantFunc(36, 12)

    instantFunc = Class()::average
    instantFunc(25, 15)
}