package me.jincrates.kotlin200forbeginners.part03.ex110_generic;

/*
110. 제네릭(Generic)
제네릭이라는 문법을 이용하면, 인수를 전달하듯이 함수에 타입을 전달할 수 있다.
fun 키워드와 함수 이름 사이의 <식별자> 부분을 타입 매개변수라고 부른다.

여기서는 식별자를 T로 했으므로, T라는 이름의 타입 매개변수가 만들어진다.
이제 T를 하나의 타입처럼 사용할 수 있다.
T 타입의 인수를 받아서 그 값을 그대로 돌려주는 함수를 반환하는 함수 toFunction을 선언했다.

제네릭이 적용된 함수를 호출하려면 함수 이름 엽에 <타입 이름>을 적는다.
여기서 타입 이름 부분을 타입 인수 라고 부른다.
타입 인수를 지정하면, toFunction 함수에서 T로 적힌 부분이 모두 해당 타입으로 치환된다.
예를 들어, toFunction<Int>와 같이 적으면 toFunction 안의 T 타입이 모두 Int로 바뀐다.
 */

fun <T> toFunction(value: T): () -> T = { value }

fun main(args:Array<String>): Unit {

    val func: () -> Int = toFunction<Int>(1107)
    println(func())
}