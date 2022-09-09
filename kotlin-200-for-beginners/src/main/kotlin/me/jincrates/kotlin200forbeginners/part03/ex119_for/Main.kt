package me.jincrates.kotlin200forbeginners.part03.ex119_for;

/*
119. 흐름 제어-반복문 for
for도 while과 같이 코드를 반복하는 반복문의 일종이다.

for (변수 이름: 타입 in 표현식) {
    ...
}

for 문의 소괄호 안에 선언된 변수는 스코프가 for 문 안으로 한정되며,
in 우측 표현식 속의 데이터를 하나씩 받는데 사용한다.

for 문의 in 연산자는 다른 in 연산자와 다르다.
for 문 속 in 연산자는 비록 in이라는 키워드로 되어있지만 일반적인 in 연산자와 다르게 봐야한다.
contains 연산자 멤버 함수가 있어야 지원되는 일반적인 in 연산자와 달리,
for 문 속의 in 연산자는 iterator 연산자 멤버 함수만 있으면 지원되기 때문이다.
제네릭의 in과 마찬가지로 동음 이의 키워드로 생각하면 된다.
 */
fun main(args:Array<String>): Unit {

    for (i in 1..10) {
        print("$i ")
    }
    println()

    for (i in 1..10) {
        if (i > 5) {
            break
        }
        print("$i ")
    }
}