package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex179_nullable_string_plus;

/*
179. String?.plus 연산자 확장 함수
코틀린에는 String?.plus 연산자 확장 함수가 내장되어 있어 값이 null인 String 타입 표현식에도 + 연산자를 사용할 수 있다.
 */
fun main(args:Array<String>): Unit {

    val nullStr: String? = null
    println(nullStr + "테스트")
}