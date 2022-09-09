package me.jincrates.kotlin200forbeginners.part01_basic_grammar;

/*
030. 함수(Function)

fun 식별자(): 반환 타입 {
    함수에 포함시킬 문장
}

 */
fun main(args:Array<String>): Unit {

    println(myFunction())
    println(myFunction() + 10)
}

fun myFunction(): Int {
    val a = 3
    val b = 6
    println("a: $a, b: $b")
    return a + b
}