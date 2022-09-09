package me.jincrates.kotlin200forbeginners.part01_basic_grammar;

/*
036. 지역 변수(Local Variable)와 전역 변수(Global Variable)
함수 밖에서 선언한 변수는 함수 호출이 끝나도 사라지지 않는다.
반면, 블록 안에서 선언한 변수는 블록 밖으로 나가면 사라진다.

여기서 밖에 선언한 변수를 전역 변수(Global Variable)), 블록 안에 선언한 변수를 지역 변수(Local Variable)라고 한다.

전역 변수는 어떤 함수에도 속해있지 않기 때문에 모든 함수에서 사용할 수 있다.
그러나 지역 변수는 그 변수가 속한 지역, 즉 변수가 선언된 블록 안에서만 인식하게 된다.
여기서 변수가 인식될 수 있는 범위를 스코프(Scope)라고 한다.

전역 변수는 여러 함수에서 접근할 수 있어 편리할 수 있지만,
변수를 특정 블록에서만 사용한다면 지역 변수로 써준느 것이 좋다.
전역 변수는 접근할 수 있는 범위가 너무 넓어 변수가 사용되는 지점과 값이 바뀌는 지점을 한눈에 파악하기가 어렵기 때문이다.
 */
var count = 0
fun main(args:Array<String>): Unit {

    val a = 15
    println(a)

    count += 1
    printCount()
    println(count)  // 전역 변수 count는 값이 계속 유지된다.
}

fun printCount() {
    println(count)
    count += 1
}
