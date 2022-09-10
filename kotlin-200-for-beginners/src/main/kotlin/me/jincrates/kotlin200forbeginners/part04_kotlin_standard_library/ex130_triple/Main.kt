package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex130_triple;

/*
130. Triple 클래스: 세 변수를 하나로 묶기
Triple 클래스를 이용하면 세 변수를 하나의 변수로 묶을 수 있다.
 */
fun calculateCircle(radius: Int): Triple<Int, Double, Double> =
        Triple(radius * 2, radius * 2 * 3.14, 3.14 * radius * radius)

fun main(args:Array<String>): Unit {

    val(diameter, _, area) = calculateCircle(5)
    println("지름: $diameter")
    println("넓이: $area")
}