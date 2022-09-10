package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex134_progression_practice;

/*
134. Progression과 관련된 함수
코틀린에서 제공하는 확장 함수를 이용하면 Progression 타입들을 제대로 활용할 수 있다.
 */
fun IntProgression.print() {
    println("first: ${this.first}, last: ${this.last}, step: ${this.step}")

    for (i in this) {
        print("$i ")
    }

    println("\n")
}

fun main(args:Array<String>): Unit {

    val prog: IntProgression = 7 downTo 3
    prog.print()

    val prog2: IntProgression = (3..7).reversed()
    println(prog == prog2)
    prog2.print()

    val prog3: IntProgression = (1..10) step 3
    prog3.print()

    val prog4: IntProgression = 10 downTo 2 step 3
    prog4.print()

    val prog5: IntProgression = 2 until 5
    prog5.print()
}