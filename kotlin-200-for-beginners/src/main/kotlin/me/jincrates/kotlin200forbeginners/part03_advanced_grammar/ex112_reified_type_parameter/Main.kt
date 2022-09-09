package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex112_reified_type_parameter;

/*
112. 구체화된(Reified) 타입 매개변수
타입 매개변수는 대부분의 상황에서 일반 타입처럼 쓸 수 있다.
특정 상황에서는 그렇지 못하다.
타입 매개변수는 is 연산자의 피연산자로 사용할 수 없다.

단, 타입 매개변수 앞에 reified을 붙여주면 해당 타입 매개변수를 in 연산자에 사용할 수 있다.
타입변수에 reified를 붙이려면 함수를 반드시 inline으로 선언해야 한다.
 */
inline fun <reified T> check() {
    val number = 0
    if (number is T) {
        println("T는 Int 타입 입니다.")
    }
}
fun main(args:Array<String>): Unit {
    check<Int>()
}