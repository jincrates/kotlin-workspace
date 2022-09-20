package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex181_verify_value;

/*
181. 인수(Argument) 검증하기
check와 require 함수를 이용하면 값이 특정 조건을 만족하지 않을 때 예외를 던질 수 있다.
보통 매개변수에 들어온 값이 유효한지 검사할 때 사용한다.
 */
fun func(num: Int?) {
    checkNotNull(num)
    check(num!! > 0)
}

fun func2(num: Double?) {
    requireNotNull(num)
    require(num!!.isNaN())
}

fun main(args:Array<String>): Unit {
    func(10)
    func2(0.0 / 0.0)
}