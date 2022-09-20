package me.jincrates.kotlin200forbeginners.part05_kotlin_java_together.ex195_java_to_kotlin_operator_overloading;

/*
195. 코틀린에서 자바 코드 접근하기: 연산자 오버로딩
 */
fun main(args:Array<String>): Unit {

    val java = JavaClass()

    println(13 in java)
    println(java[13])
    println(java[28])
    println(java[18])
}