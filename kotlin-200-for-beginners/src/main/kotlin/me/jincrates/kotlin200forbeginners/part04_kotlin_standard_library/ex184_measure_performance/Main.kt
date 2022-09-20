package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex184_measure_performance;

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

/*
184. 코드 성능 측정하기
가끔 코드의 실행 속도를 측정해야 할 때가 있다.
이럴 때는 measureTimeMillis 또는 measureNanoTime 함수를 사용한다.

measureTimeMillis: 함수가 끝나기까지 경과한 시간을 밀리 초 단위로 반환한다.
measureNanoTime: 함수가 끝나기까지 경과한 시간을 나노 초 단위로 반환한다.
 */
fun main(args:Array<String>): Unit {

    println(measureTimeMillis {
        var sum = 0L
        for(i in 1..100000000) {
            sum += i
        }
    })

    println(measureNanoTime {
        var sum = 0L
        for (i in 1..100000000) {
            sum += i
        }
    })
}