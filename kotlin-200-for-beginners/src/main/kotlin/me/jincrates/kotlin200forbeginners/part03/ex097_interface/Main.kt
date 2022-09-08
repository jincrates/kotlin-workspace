package me.jincrates.kotlin200forbeginners.part03.ex097_interface;

/*
097. 인터페이스(Interface)
인터페이스는 클래스에 어떤 멤버 함수와 프로퍼티가 반드시 존재한다는 것을 보장하기 위한 장치이다.
class 키워드 대신 interface 키워드르 사용하면 인터페이스를 선언할 수 있다.
인터페이스는 멤버 함수, 추상 멤버 함수, 추상 프로퍼티를 가질 수 있다.
일반 프로퍼티와 생성자는 가질 수 없다.

일반 멤버 함수를 가질 수 있는 코틀린 인터페이스
코틀린의 인터페이스는 Java 8의 인터페이스처럼 멤버 함수가 기본 구현을 가질 수 있다.

인터페이스는 '상속'이 아닌 구현(Implementation)이라는 표현을 쓴다.

인터페이스는 어디에 쓰는 것이 좋을까? 일단 인터페이스는 기존의 클래스를 확장한다는 것보다는,
어떤 클래스에 플로그인을 추가하는 개념에 가깝다.
 */
interface Printable {
    fun print(): Unit
}

class AAA: Printable {
    override fun print() {
        println("Hello")
    }
}

fun print(anything: Printable) {
    anything.print()
}

fun main(args:Array<String>): Unit {
    print(AAA())
}