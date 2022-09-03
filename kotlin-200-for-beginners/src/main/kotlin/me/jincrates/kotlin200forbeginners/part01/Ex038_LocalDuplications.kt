package me.jincrates.kotlin200forbeginners.part01;

/*
038. 지역 변수와 다른 함수의 지역 변수가 중복될 때
지역 변수의 이름은 같은 스코프 내에서만 중복되지 않으면 되기 때문에
다른 함수 안에 같은 이름의 변수가 존재할 수 있다.
지역 변수 간에 스코프가 겹치지 않기 때문에 함수 간에 변수의 이름이 같아도 문제 없다.
함수마다 저마다의 a 변수를 가지며, 이 변수들은 이름만 같을 뿐 완전히 서로 다른 변수이다. .
마치 이 세상에 동명이인이 있는 것처럼 동명이변수도 있는 셈이다.
 */

fun main(args:Array<String>): Unit {

    val a = 52
    println(a)

    printA()
    printA2()
}

fun printA() {
    val a = 17
    println(a)
}

fun printA2() {
    val a = 120
    println(a)
}
