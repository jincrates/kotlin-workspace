package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex071_exception;

/*
071. 예외(Exception)
예외란 프로그램 실행 중 예상치 못하게 발생한 상황을 뜻한다.
예외가 발생하면 프로그램은 기본적으로 오류 메시지와 함께 강제 종료된다.

예외가 발생하면 그 즉시 프로그램이 강제 종료되며, 그 아래에 있는 코드들은 실행되지 않는다.
 */
fun main(args:Array<String>): Unit {

    val str = "abcd"
    val num = str.toInt()

    println(num)
}