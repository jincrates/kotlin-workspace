package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex178_nullable_to_string;

/*
178. Any?.toString 확장함수
Any?.toString은 값이 null인 표현식에도 toString을 호출할 수 있게 해주는 매우 유용한 확장 함수이다.
 */
fun main(args:Array<String>): Unit {

    val empty: Int? = null
    val str: String = empty.toString()
    println(str)
}