package me.jincrates.kotlin200forbeginners.part02.ex045_object

/*
045. 객체(Object)
객체란 우리가 인식할 수 있는 물체 또는 물건을 뜻한다.
객체들은 각자의 고유한 속성과 동작을 갖고 있다.

예를 들어
가방은 '용량'과 '색상'이라는 속성, 그리고 '담는다'라는 동작을 가질 수 있다.
사람은 '이름'과 '나이'라는 속성, 그리고 '말하다' 정도의 동작을 가질 수 있다.

소프트웨어 관점에서 객체란, 서로 연관 있는 변수(속성)들을 묶어놓는 데이터 덩어리를 뜻한다.
만약 객체라는 개념이 없으면 다음과 같이 변수를 선언해야 한다.

val personName = "홍길동"
val personAge = 29

이렇게 하면 person 부분이 겹쳐서 코드가 중복되는 문제가 있다.
object 키워드를 이용하면 이러한 중복 코드를 줄일 수 있다.

name, age처럼 object(객체)에 포함된 변수들을 프로퍼티(Property)라고 부른다.
프로퍼티는 우리말로 '속성'이다. 프로퍼티는 반드시 선언과 동시에 초기화해야 한다.

필드와 프로퍼티
코틀린의 프로퍼티는 언뜻 보면 자바의 필드와 동일하다.
그럼에도 왜 코틀린에서는 필드라는 용어 대신 프로퍼티라는 용어를 사용했을까?
그 이유는 사실 프로퍼티는 필드와 같지 않기 때문이다. 이후 설명하겠지만,
프로퍼티는 필드와 Getter, Setter가 합쳐진 개념이다.
 */
fun main(args:Array<String>): Unit {

    val person = object {
        val name: String = "홍길동"
        val age: Int = 29
    }

    println(person.name)
    println(person.age)
}