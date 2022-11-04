package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex113_generic_to_class_and_interface;

/*
113. 클래스와 인터페이스에서 제네릭 사용하기
클래스와 인터페이스에도 제네릭을 적용할 수 있다.
클래스나 인터페이스에서 타입을 인수로 받으려면 선언시 이름 앞에 <식별자>를 붙인다.
 */
fun main(args:Array<String>): Unit {
    val pair: Pair<Int, Double> = Pair(15, 9.12)
    println(pair.toString())
}