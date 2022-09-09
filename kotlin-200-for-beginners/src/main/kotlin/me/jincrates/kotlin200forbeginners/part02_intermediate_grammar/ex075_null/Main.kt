package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex075_null;

import me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex065_upcasting.Person

/*
075. Nullable 타입과 null
타입 이름 뒤에 ?를 붙이면 변수를 Nullable하게 만들 수 있다.
Nullable이란, null 값을 지정할 수 있는 변수를 뜻한다.
null은 참조 변수가 어떠한 객체를 가리키지 않고 있음을 나타내는 키워드이다.

기본적으로 null을 지정할 수 없는 코틀린
자바는 모든 참조 타입에 기본적으로 null을 지정할 수 있다.
하지만, 코틀린에서는 Nullable 타입이 아니면 null을 지정하지 못한다.
 */
fun main(args:Array<String>): Unit {

    //업케이스팅 예제의 Person 클래스 재활용
    var person: Person? = Person("K", 30)
    person = null

    var num: Int? = null
    num = 10
}