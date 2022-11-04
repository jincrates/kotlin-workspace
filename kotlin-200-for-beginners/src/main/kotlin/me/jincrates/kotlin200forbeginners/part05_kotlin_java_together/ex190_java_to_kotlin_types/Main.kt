package me.jincrates.kotlin200forbeginners.part05_kotlin_java_together.ex190_java_to_kotlin_types;

/*
190. 코틀린에서 자바 코드 접근하기: 타입
 */
fun main(args:Array<String>): Unit {

    val rand: Double = Math.random()
    println(rand)

    val buffer: StringBuffer = StringBuffer()
    buffer.append("hello, ")
    buffer.append("world!")
    val result: String = buffer.toString()
    println(result)
}