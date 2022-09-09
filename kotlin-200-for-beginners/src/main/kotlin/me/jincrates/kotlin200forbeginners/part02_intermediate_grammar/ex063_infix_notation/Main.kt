package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex063_infix_notation;

/*
063. 멤버 팜수의 중위 표기법(Infix Notation)
중위 표기법이란, 피연산자 연산자 피연산자의 순서로 표현식을 구성하는 방식을 뜻한다.
멤버 함수의 매개변수가 하나뿐이면 함수 호출을 중위 표기법으로 할 수 있다.

중위 표기법을 지원하려면 멤버 함수 선언문 앞에 infix를 붙여야 한다.
점과 소괄호 한 쌍이 줄어들어 더 읽기 편해진 것을 볼 수 있다.
 */
class Point(var x: Int = 0, var y: Int = 0) {

    // base를 원점으로 생각했을 때의 좌표를 반환한다.
    infix fun from(base: Point): Point {
        return Point(x - base.x, y - base.y)
    }
}

fun main(args:Array<String>): Unit {

    val pt = Point(3, 6) from Point(1, 1)
    println(pt.x)
    println(pt.y)
}