package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex180_verify_real_number;

/*
180. Double 값 검증하기
Double 타입에는 Nan(Not a Number, 숫자가 아님) 또는 Infinite(무한)이라는 특수 값이 들어갈 수 있다.
 */
fun main(args:Array<String>): Unit {

    val a: Double = 0.0 / 0.0
    val b: Double = 7 / 0.0
    val c: Double = 3.2

    print("$a ")
    println(a.isNaN())

    print("$b ")
    println(b.isInfinite())

    print("$c ")
    println(c.isFinite())
}