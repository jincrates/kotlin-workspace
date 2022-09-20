package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex187_thread_function;

import kotlin.concurrent.thread

/*
187. thread 함수: 스레드 생성하기
코틀린의 스레드는 thread 함수를 통해 생성할 수 있다.
 */
fun main(args:Array<String>): Unit {

    thread(start = true) {
        print("Hello, ")
        Thread.sleep(1000)
        print("World!")
    }

    Thread.sleep(500)
    print("Kotlin ")
}