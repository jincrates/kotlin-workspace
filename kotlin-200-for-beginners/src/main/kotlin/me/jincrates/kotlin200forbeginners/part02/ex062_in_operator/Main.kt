package me.jincrates.kotlin200forbeginners.part02.ex062_in_operator;

/*
062. in 연산자
in 연산자는 어떤 값이 객체에 포함되어 있는지 여부를 조사하는 역할을 한다.

'o' in "Kotlin"는 컴파일 시 "Kotlin".contains('o')로 번역된다.
 */
fun main(args:Array<String>): Unit {

    println('o' in "Kotlin")
    println("in" !in "Kotlin")
}