package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex098_the_diamond_problem;

/*
098. 다이아몬드 문제(The Diamond Problem)
코틀린은 이런 상황을 위해 원하는 인터페이스의 super를 호출할 수 있는 기능을 제공한다.
 */
interface Parent { fun follow():Unit }

interface Mother: Parent {
    override fun follow() = println("follow his mother")
}

interface Father: Parent {
    override fun follow() = println("follow his father")
}

class Child: Mother, Father {
    override fun follow() {
        println("A child decided to")
        super<Mother>.follow()
    }
}

fun main(args:Array<String>): Unit {
    Child().follow()
}