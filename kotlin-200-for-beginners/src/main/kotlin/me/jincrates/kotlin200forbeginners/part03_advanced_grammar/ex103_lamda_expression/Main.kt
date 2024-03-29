package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex103_lamda_expression;

/*
103. 함수 리터럴(Function Literal)과 람다식(Lambda Expression)
함수 리터럴이란 말 그대로 함수를 나타내는 리터럴이라는 뜻이다.

(Int) -> Unit은 매개변수가 Int 타입이고 반환 타입이 Unit인 함수를 저장할 수 있는 타입이다.
이처럼 함수를 저장할 수 있는 타입을 함수 타입(Function Type)이라고 한다.

함수 리터럴에는 return을 적지 않는다.
함수 리터럴의 반환 값은 함수 내용의 맨 마지막 표현식이 된다.

일반적으로는 ()로 바로 호출하면 되지만,
변수가 Nullable일 때는 invoke를 통해서 호출하는 편이 instantFunc?.invoke(33)과 같이 쓸 수 있으므로
Null 처리를 하기 편해진다.

코틀린에서는 함수 리터럴을 두 가지 형태로 만들 수 있다.
{ 매개변수 -> 반환 값 } 형태가 그 중 하나이며, 이를 람다식이라고 부른다.
 */
fun main(args:Array<String>): Unit {

    val instantFunc: (Int) -> Unit = { number: Int -> //-> 를 경계로, 매개변수와 함수의 내용이 분리된다.
        println("Hello $number")
    }

    instantFunc(33)
    instantFunc.invoke(33)
}