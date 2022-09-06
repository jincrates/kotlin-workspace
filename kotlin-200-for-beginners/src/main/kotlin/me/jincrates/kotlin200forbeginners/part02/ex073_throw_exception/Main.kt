package me.jincrates.kotlin200forbeginners.part02.ex073_throw_exception;

import java.lang.Exception

/*
073. 예외 던지기
예외는 기본적으로 시스템에 의해 일어나지만, 우리가 고의로 예외를 발생시킬 수도 있다.
이렇게 예외를 발생시키는 것을 '예외를 던진다'라고 표현한다.

예외를 던질 떄는 다음과 같이 쓴다.
throw Throwable 타입 표현식

여기서는 Throwable이 아닌 Exception의 인스턴스를 생성했는데, Exception이 Throwable 클래스를 상속하므로 문제 없다.
Exception 클래스의 생성자로 String 값을 전달하면 예외의 원인을 알려주는 메시지를 지정할 수 있다.
예외가 던져지는 순간, 그 아래 있는 코드들은 모두 무시된다.

예외가 던져지면 자신이 호출했던 함수로 예외 처리의 책임을 전가시킨다.
그 함수에서도 예외 처리를 하지 않으면, 그 함수를 호출했던 함수로 또 예외 처리의 책임을 전가한다.
그러다 보면 언젠가는 main 함수까지 예외 처리의 책임이 도달하게 된다.
main 함수는 예외처리를 할 수 있는 최후의 보루이다. main 함수를 호출하는 함수는 시스템 밖에 없기 떄문이다.
main 함수에서마저도 예외를 처리하지 않으면 프로그램은 강제 종료된다.

코틀린의 throws 키워드?
코틀린에는 throws 키워드가 없다. 코틀린 함수는 자바처럼 메서드 선언에 예외 정보를 포함하지 않는다.
왜 그럴까? 알다시피 자바에서는 throws가 있는 함수를 호출할 때마다 매번 함수 호출을 try-catch 블록으로 감싸야만 한다.
하지만, 간결함을 중시하는 코틀린에서는 이런 지저분한 코드를 용납할 수 없었고, 결국 과감히 throws 키워드를 제거해 버렸다.
코틀린에서의 예외 처리는 이제 필수가 아닌 옵션이다.
 */
fun main(args:Array<String>): Unit {
    try {
        something()
    } catch (e: Exception) {
        println(e.message)
    }
}

fun something() {
    val num1 = 10
    val num2 = 0
    div(num1, num2)
}

// a를 b로 나눈 몫을 반환하는 함수
fun div(a: Int, b: Int): Int {
    if (b == 0) {
        throw Exception("0으로 나눌 수 없습니다.")
    }
    return a / b
}

