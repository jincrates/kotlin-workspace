package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex131_comparable_interface;

/*
131. Comparable 인터페이스: 클래스를 비교 가능하게 만들기
Comparable 인터페이스를 구현하는 클래스는 비교 연산자(>, <, >=, <=)를 지원하게 된다.
 */
class Rectangle(val width: Int, val height: Int): Comparable<Rectangle> {

    val area = width * height

    override fun compareTo(other: Rectangle): Int =
            when {
                this.area > other.area -> 1
                this.area < other.area -> -1
                else -> 0
            }
}

fun main(args:Array<String>): Unit {

    val rect = Rectangle(3, 5)
    val rect2 = Rectangle(7, 3)
    val rect3 = Rectangle(2, 9)

    println(rect >= rect3)
    println(rect < rect2)
    println(rect2 > rect3)
}