package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex114_inherit_from_generic;

/*
114. 제네릭이 적용된 클래스/인터페이스 상속/구현하기
제네릭이 적용된 클래스나 인터페이스는 상속할 때 타입 인수를 전달해 주어야 한다.
 */
fun main(args:Array<String>): Unit {

    val rect = Rectangle(10, 5)
    val rect2 = Rectangle(3, 8)

    println(rect + rect2)
}