package me.jincrates.kotlin200forbeginners.part02.ex068_polymorphism;

/*
068. 다형성(Polymorphism)의 활용
오버라이딩된 멤버 함수를 호출하면 참조 변수가 실제로 가리키고 있는 객체의 멤버 함수가 호출된다.
 */

open class AAA {
    open fun hello() = println("AAA 입니다.")
}

class BBB: AAA() {
    override fun hello() = println("BBB 입니다.")
}

fun main(args:Array<String>): Unit {

    val one = AAA()
    val two = BBB()
    val three: AAA = two

    one.hello()
    two.hello()
    three.hello()
}