package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex061_invoke_operator;

/*
061. 호출 연산자(invoke Operator)()
()는 함수를 호출할 때 사용하는 연산자이다. 코틀린에서는 이런 연산자도 오버로딩이 가능하다.
() 연산자를 오버로딩 하는 함수는 invoke를 선언하고 있다.
본 예제에서는 하나의 인수만 적었지만, 인수의 개수는 자유다.
인수를 아예 생략할 수도 있다.

product(108)은 컴파일 시 product.invoke(108)로 번역된다.
 */
fun main(args:Array<String>): Unit {

    val product = Product(762443, "코틀린 200제")
    product(108)
}