package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex128_pair;

/*
128. Pair 클래스: 두 변수를 하나로 묶기
Pair 클래스를 이용하면 두 변수를 하나로 묶을 수 있다.
Pair 클래스는 코틀린 표준 라이브러리 곳곳에서 활용하므로 잘 기억해두자

data class Pair<out A, out B>(
    val first: A
    val second: B
) : Serializable
 */

// 두 수의 몫과 나머지를 반환한다.
fun divide(a: Int, b: Int): Pair<Int, Int> = Pair(a / b, a % b)

fun main(args:Array<String>): Unit {

    val (q, r) = divide(10, 3)
    println("몫: $q")
    println("나머지: $r")
}