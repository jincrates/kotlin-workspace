package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex188_timer_function;

import java.util.*
import kotlin.concurrent.timer

/*
188. timer 함수: 타이머 생성하기
timer 함수를 이요하면 미리 설정해 놓은 주기마다 지정한 함수를 실행하게 할 수 있다.
 */
fun main(args:Array<String>): Unit {

    var i = 1
    val t: Timer = kotlin.concurrent.timer(initialDelay = 1500, period = 250) {
        println(i)
        i += 1
    }

    Thread.sleep(2400)
    t.cancel()
}