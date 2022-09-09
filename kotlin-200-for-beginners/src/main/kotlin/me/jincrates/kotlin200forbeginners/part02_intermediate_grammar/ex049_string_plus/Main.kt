package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex049_string_plus;

/*
049. 문자열간 + 연산 시 중의점
String 타입의 변수는 스택 영역에 문자열을 저장하는 것처럼 표현했지만,
사실 실제 문자열은 힙 영역에 생성되며, String 변수는 문자열의 참조값을 저장하기 위한 공간만 갖고 있다.
문자열끼리 + 연산을 하면 원래 갖고 있던 문자열에 새로운 문자열이 덧붙여지는게 아니라,
기존의 문자열은 그대로 남고 합쳐진 문자열이 새로 생성된다.

이렇게 + 연산을 할 때마다 힙에 문자열이 계속 쌓여 나간다면,
분명 언젠가는 메모리 공간을 모두 차지해버릴 것이다.
 */
fun main(args:Array<String>): Unit {
    var first = "Hello "
    var second = "World!"
    first += second
}