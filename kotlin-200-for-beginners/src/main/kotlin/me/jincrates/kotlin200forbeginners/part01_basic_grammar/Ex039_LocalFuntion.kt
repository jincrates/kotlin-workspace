package me.jincrates.kotlin200forbeginners.part01_basic_grammar;

/*
039. 지역 함수(Local Function)
만약, 어떤 함수가 특정 함수 안에서만 사용된다면, 지역 함수라는 것을 사용해볼 수 있다.
지역 함수(Local Function)란, 블록 안에 선언된 함수를 뜻한다.
 */
fun main(args:Array<String>): Unit {

    fun printFormula(a: Int, b: Int) {
        println(a * b + a - b)
    }

    printFormula(73, 1)
    printFormula(4, 6)
}