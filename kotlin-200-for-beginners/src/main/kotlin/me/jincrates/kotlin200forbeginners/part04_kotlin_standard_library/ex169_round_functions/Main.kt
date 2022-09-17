package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex169_round_functions;

import kotlin.math.*
/*
169. 실수 값 올림/내림/반올림 하기
코틀린에는 실수 값을 올림/내림/반올림하는 함수를 기본적으로 제공한다.
 */
fun main(args:Array<String>): Unit {

    print("${ceil(3.2)}")
    print("${ceil(3.7)}")
    print("${floor(3.2)}")
    print("${floor(3.7)}")
    print("${round(3.2)}")
    print("${round(3.7)}")
    print("${15.83.roundToInt()}")
    print("${37842.45.roundToLong()}")
}