package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex092_lateinit;

/*
092. lateinit
클래스의 프로퍼티는 선언과 동시에 초기화하거나 init 블록 안에서 반드시 초기화해주어야 한다.
그러나 이런 강제성은 너무 불편하다.

lateinit 키워드가 붙은 프로퍼티는 클래스 안에서 바로 초기화하지 않아도 된다.
lateinit은 var 프로퍼티에만 붙일 수 있다.

lateinit 프로퍼티가 초기화되었는지 여부를 확인하는 방법
if (rect::pt.isInitialized) {}
 */

// 점을 표현하는 클래스
class Point(val x: Int, val y: Int)

// 사각형을 표현하는 클래스
class Rect {
    lateinit var pt: Point
    lateinit var pt2: Point

    val width: Int get() = pt2.x - pt.x
    val height: Int get() = pt2.y - pt.y
    val area get() = width * height
}
fun main(args:Array<String>): Unit {

    val rect = Rect()
    rect.pt = Point(3, 3)
    rect.pt2 = Point(6, 5)

    println("너비: ${rect.width}")
    println("높이: ${rect.height}")
    println("넓이: ${rect.area}")
}