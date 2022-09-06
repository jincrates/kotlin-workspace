package me.jincrates.kotlin200forbeginners.part03.ex090_inline_function;

/*
090. inline 함수
함수를 호출하면 함수 속으로 실행 흐름이 점프하고, 함수가 끝나면 함수를 호출했던 지점으로 다시 점프한다.
이때 발생하는 실행 흐름의 이동은 프로그램의 성능을 미세하게 저해한다.

inline 함수를 사용하면, 실행 흐름을 점프하지 않고 함수 호출문을 함수의 몸체로 대체하기 때문에
성능을 조금이나마 개선할 수 있다.

함수 앞에 inline 키워드를 붙이면 그 함수는 inline 함수가 된다.
아래 main 함수 호출문은 컴파일 되는 순간 다음처럼 코드가 대체된다.
fun main() {
    println("Hello")
    println("Kotlin")
    println("Hello")
    println("Kotlin")
    println("Hello")
    println("Kotlin")
}

inline 함수는 함수 속의 문장을 재활용하지 않기 떄문에,
문장이 많은 함수를 inline으로 바꾸면 프로그램의 크기가 기하급수적으로 늘어난다.
이렇게 되면 inline을 안 쓰느니만 못하게 된다.

문장이 적고 빈번히 호출되는 함수만 inline으로 만들 것을 권장한다.

inline 함수의 재귀호출?
inline 함수는 재귀호출이 불가능하다. 함수 몸체 코드가 무한대로 늘어날 수 있기 때문이다.
 */
inline fun hello() {
    println("Hello")
    println("Kotlin")
}

fun main(args:Array<String>): Unit {
    hello()
    hello()
    hello()
}