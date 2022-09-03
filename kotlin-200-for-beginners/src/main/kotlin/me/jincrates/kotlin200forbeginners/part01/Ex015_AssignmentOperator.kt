package me.jincrates.kotlin200forbeginners.part01;

/*
015. 배정 연산자(Assignment Operator) =
배정 연산자는 변수에 값을 저장할 때 사용하는 연산자다.
 */
fun main(args:Array<String>): Unit {

    val a: Int
    var b: Int

    a = 10 + 5
    b = 10

    b += a  // b에 a의 값을 누적
    println(b)

    b %= 3  // b를 3으로 나눈 나머지를 b에 저장
    println(b)
}