package me.jincrates.kotlin200forbeginners.part01_basic_grammar;

/*
005. 산술 연산자(Arithmetic Operator) + - * / %
산술 연산자란, 가감승제를 수행하는 연산자를 말한다.
 */
fun main(args:Array<String>): Unit {
    val num1: Int = 15 - 4 * 3
    val num2: Int = 65 % 7
    val num3: Double = 7.5 / 5 + 22.25
    val num4: Double = num1 / num2 + 0.7
    val num5: Double = num1.toDouble() / num2.toDouble() + 0.7

    println(num1)
    println(num2)
    println(num3)
    println(num4)
    println(num5)
}