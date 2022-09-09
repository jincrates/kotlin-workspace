package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex059_operator_overloading

class Point(
    private var x: Int = 0,
    private var y: Int = 0
) {

    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun minus(other: Point): Point {
        return Point(x - other.x, y - other.y)
    }

    operator fun times(number: Int): Point {
        return Point(x * number, y * number)
    }

    operator fun div(number: Int): Point {
        return Point(x / number, y / number)
    }

    //좌표 값을 출력한다.
    fun print() {
        println("x: $x, y: $y")
    }
}