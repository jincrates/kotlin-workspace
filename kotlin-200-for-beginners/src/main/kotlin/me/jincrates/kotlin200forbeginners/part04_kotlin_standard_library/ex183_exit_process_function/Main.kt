package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex183_exit_process_function;

import kotlin.system.exitProcess

/*
183. exitProcess 함수: 어디서나 프로그램 종료하기
프로그램을 종료하려면 일반적으로 main 함수에서 return을 하거나, main 함수까지 예외를 던져야 한다.
하지만 이렇게 코드를 작성하는 것은 쉽지 않다.
exitProcess 함수를 이용하면, 실행 흐름이 어디에 있든 프로그램을 바로 종료시킬 수 있다.
 */
fun main(args:Array<String>): Unit {

    something(-1)
    println("Hello")
}

fun something(num: Int) {
    if (num < 0) {
        exitProcess(0)
    }
}
