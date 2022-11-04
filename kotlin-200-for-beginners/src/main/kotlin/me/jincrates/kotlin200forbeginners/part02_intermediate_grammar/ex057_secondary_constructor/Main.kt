package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex057_secondary_constructor;

/*
057. 보조 생성자(Secondary Constructor)
클래스 이름 옆에 오는 생성자는 주 생성자(Primary Constructor)이라고 한다.
클래스 내부에 오는 생성자는 보조 생성자(Secondary Constructor)이라고 하며, 여러 개가 올 수 있다.

시간을 표현하는 Time 클래스를 선언하고 있다.
초 값을 저장하는 var second: Int 프로퍼티를 선언 및 초기화하는 주 생성자를 정의하고 있다.

분과 초로 Time의 인스턴스를 초기화할 수 있는 보조 생성자를 정의하고 있다.
만약 클래스에 주 생성자가 존재한다면, 주 생성자를 반드시 먼저 호출해주어야 한다.
this(인수)는 이 클래스에 포함된 또 다른 생성자를 호출하는 문법이다.
여기서는 Int 타입 하나를 전달 했으므로 주 생성자가 호출된다.
 */
class Time(var second: Int) {
    init {
        println("init 블록 실행 중")
    }

    //보조 생성자 1
    //this 키워드는 클래스 이름을 나타내는 대명사라고 생각하면 이해하기 편하다.
    constructor(minute: Int, second: Int): this(minute * 60 + second) {
        println("보조 생성자 1 실행중")
    }

    //보조 생성자 2
    constructor(hour: Int, minute: Int, second: Int): this(hour * 60 + minute, second) {
        println("보조 생성자 2 실행중")
    }

    init {
        println("또 다른 init 블록 실행중")
    }
}
fun main(args:Array<String>): Unit {

    println("${Time(15, 6).second} 초")
    println("${Time(6, 3, 17).second} 초")

}