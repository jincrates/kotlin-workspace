package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex108_closure;

/*
108. 클로저(Closure)
앞에서 변수의 스코프 개념에 대해 알아봤었다.
지역 변수는 항상 자신이 소속된 블록이 끝나면 소멸한다.
그러나, 클로저라는 것을 이용하여 지역 변수가 소멸하지 않는 것처럼 보이도록 할 수 있다.

f를 호출하면 println(num)이 수행될 것이다.
하지만 f가 호출되는 시점에는 num 매개변수가 이미 사라지고 없다.
returnFunc 함수가 끝나는 순간 num 매개변수는 소멸하기 때문이다.
 그런데 어떻게 이런 코드가 가능한 것일까?

 그것은 바로 함수 리터럴이 자신이 만들어질 때의 상황을 기억하고 있기 때문이다.
 함수의 리터럴이 만들어지는 순간, 함수 리터럴은 자기 주변의 상황을 함께 저장한다.
 즉, 함수가 만들어질 때 num 매개변수의 값을 복사해 갖고 있는다.
 이렇게 함수가 만들어질 때 주변 상황을 기억하는 함수를 클로저(Closure)라고 부른다.
 */
fun returnFunc(num: Int): () -> Unit = { println(num) }

fun main(args:Array<String>): Unit {

    val f: () -> Unit = returnFunc(30)
    f()
}