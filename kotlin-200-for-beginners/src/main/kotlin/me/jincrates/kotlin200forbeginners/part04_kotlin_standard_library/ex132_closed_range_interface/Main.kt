package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex132_closed_range_interface;

/*
132. ClosedRange 인터페이스: 닫힌 구간을 표현하는 인터페이스
CloseRange는 타입 매개변수로 Comparable<T>를 구현하는 타입만 받는다.
대소 비교가 가능해야 범위를 형성할 수 있기 때문이다.
 */
fun main(args:Array<String>): Unit {

    val intRange: IntRange = 1..10
    val longRange: LongRange = 1L..100L
    val charRange: CharRange = 'A'..'Z'

    println(intRange.start)
    println(longRange.endInclusive)
    println('*' in charRange)
    println(charRange.isEmpty())
}