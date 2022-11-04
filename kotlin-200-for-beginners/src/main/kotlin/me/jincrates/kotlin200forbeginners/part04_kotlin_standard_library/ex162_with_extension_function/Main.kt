package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex162_with_extension_function;

/*
162. with 함수: 코드 중복 줄이기
 */
fun main(args:Array<String>): Unit {

    val a = 3; val b = 7
    with(a * b - b * b) {
        println(this)
        println(-this)
    }
}