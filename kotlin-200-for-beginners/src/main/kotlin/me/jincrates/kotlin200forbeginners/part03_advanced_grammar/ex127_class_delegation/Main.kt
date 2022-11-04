package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex127_class_delegation;

/*
127. 클래스 위임(Class Delegation)
코틀린에서는 인터페이스의 구현을 다른 클래스에 맡길 수 있는 문법 도 제공한다.
인터페이스를 구현하면서 뒤에 by 객체를 지정하면 인터페이스의 구현을 해당 객체로 위임한다.
이때 객체는 대리할 인터페이스를 구현하고 있어야 한다.

Sample() + 10을 수행하면 ClassDelegator의 plus가 호출된다.
 */
fun main(args:Array<String>): Unit {

    println(Sample() + 10)
}