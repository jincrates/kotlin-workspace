package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex166_big_integer_class;

/*
166. BigInteger 클래스: 매우 큰 정수 보관하기
BigInteger는 Long의 표현 범위를 넘는 정수를 다룰 때 사용하는 클래스이다.
BigInteger는 코틀린이 아닌 자바 표준 라이브러리에 속해있다.
따라서 BigInteger 클래를 사용하면 JVM에 의존성이 생긴다.

BigInteger는 자바의 클래스이기 때문에 그 자체로는 연산자 오버로딩을 지원하지 않지만,
코틀린 표준 라이브러리에서 BigInteger에 대한 연산자 확장 함수들을 제공하기 때문에 Ine 타입을 다루듯이 사용할 수 있다.
 */
fun main(args:Array<String>): Unit {

    val a = 78423343545.toBigInteger()
    val b = 25372465331.toBigInteger()

    println(a * b)
    println(a + b * 936273.toBigInteger())
}