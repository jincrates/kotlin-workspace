package me.jincrates.kotlin200forbeginners.part03.ex117_range;

/*
117. .. 연산자와 범위 표현식(Range Expression)
.. 연산자는 범위를 표현하는 연산자이다.
.. 연산자는 operator fun rangeTo(매개변수: 자유 타입): 자유타입으로 오버로딩할 수 있다.

어떤 값이 특정 범위에 있는지 조사할 때 .. 연산자를 쓰면 좋다.
.. 연산자를 쓰는 것이 코드도 짧고, 읽기도 쉽다.
 */
fun main(args:Array<String>): Unit {

    val oneToTen: IntRange = 1..10
    println(5 in oneToTen)

    val upperAtoZ: CharRange = 'A'..'Z'
    if ('C' in upperAtoZ) {
        println("대문자입니다.")
    }

    if('p' in 'a'..'z') {
        println("소문자입니다.")
    }
}