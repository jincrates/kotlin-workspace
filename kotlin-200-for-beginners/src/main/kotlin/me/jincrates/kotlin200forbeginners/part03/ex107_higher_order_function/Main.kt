package me.jincrates.kotlin200forbeginners.part03.ex107_higher_order_function;

/*
107. 고차 함수(Higher-order Function)
함수 리터럴은 보통 고차 함수를 위해 사용된다.
고차 함수란, 인수로 함수를 받거나 함수를 반환하는 함수를 뜻한다.

어떤 작업을 시작하고 끝낼 때마다 "=== 작업시작 ===", "=== 작업 끝 ==="을 출력하려고 한다.
그런데 매번 println을 호출하자니 코드가 중복되어 보기에 좋지 않다.
고차 함수를 이용하면 이 코드 조각을 멋지게 고칠 수 있다.

어떤 함수를 호출하기 전/후에 수행해야 할 고정적인 작업이 있다면 고차 함수를 활용해보자.
 */
fun decorate(task:() -> Unit) {
    println("=== 작업 시작 ===")
    task()
    println("=== 작업 끝 ===")
}

fun main(args:Array<String>): Unit {

    decorate {
        val a = 10
        val b = 5
        println("$a + $b = ${a + b}")
    }

    decorate {
        println("some")
        println("tasks")
    }
}