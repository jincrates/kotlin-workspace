package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex189_synchronized_function;

import kotlin.concurrent.thread

/*
189. synchronized 함수: 스레드 동기화
코틀린에서는 동기화를 위한 키워드를 따로 제공하지 않는다.
스레드를 동기화하려면 synchronized 함수를 이용해야 한다.
 */
private var obj: Int = 0

private fun objPlus() {
    for (i in 1..1000) {
        synchronized(obj) {
            obj++
        }
    }
}

fun main(args:Array<String>): Unit {
    thread { objPlus() }
    objPlus()
    Thread.sleep(100)
    println(obj)
}