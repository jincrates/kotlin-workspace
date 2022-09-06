package me.jincrates.kotlin200forbeginners.part02.ex072_exception_handling;

import java.lang.NumberFormatException

/*
072. 예외 처리
예외처리를 하지 않으면 프로그램은 무조건 강제 종료된다.
그러나 프로그램이 이렇게 원치 않게 종료된다면 사용자로부터 좋은 평가를 받지 못할 것이다.

코틀린에서는 예외가 발생했을떄 이를 처리할 수 있는 기회를 제공한다.
예외 처리를 하면 프로그램이 강제 종료되는 것을 막을 수 있다.

예외가 발생할 가능성이 잇는 부분을 try 블록으로 감싼다.
finally 블록은 예외 발생 여부와 상관 없이 무조건 실행되는 블록이다.
즉, try 블록 안의 코드를 무사히 마쳐도, 예외가 발생해 catch 블록으로 빠져도,
finally 블록은 항상 실행된다.
finally 블록은 생략이 가능하다.
 */
fun main(args:Array<String>): Unit {

    try {
        val str = "abcd"
        val num = str.toInt()

        println(num)
    } catch (e: NumberFormatException) {
        println("문자열을 숫자로 변경하지 못함")
    } finally {
        println("프로그램 종료")
    }
}