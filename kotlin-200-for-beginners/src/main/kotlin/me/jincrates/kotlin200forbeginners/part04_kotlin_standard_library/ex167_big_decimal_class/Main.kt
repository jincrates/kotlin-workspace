package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex167_big_decimal_class;

/*
167. BigDecimal 클래스: 매우 작은 실수 보관하기
Double의 표현 범위를 넘는 실수를 다룰 때 사용하는 클래스이다.
BigInteger와 마찬가지로, 자바 표준 라이브러리에 선언되어 있는 클래스이기 떄문에 JVM에 의존성을 가진다.
BIgDecimal 클래스를 이요하면 소수점 자리가 아무리 길어도 실수값을 정확하게 표현할 수 있어 실수 타입의 고질적인 문제인 오차 문제가 해결된다.
 */
fun main(args:Array<String>): Unit {

    val a = 3.000000000000003.toBigDecimal()
    val b = 4.000000000000004.toBigDecimal()
    println(a * b)
}