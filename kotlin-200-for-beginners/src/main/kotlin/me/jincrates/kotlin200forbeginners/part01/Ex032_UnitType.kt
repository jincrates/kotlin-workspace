package me.jincrates.kotlin200forbeginners.part01;

/*
032. Unit 타입
함수를 작성하다 보면 가끔 반환 값이 필요하지 않을 때가 있다. 이때 Unit 타입을 작성하면 된다.
반환 타입이 Unit이면 함수 끝에 return을 쓰지 않아도 된다.

코틀린의 Unit 타입은 자바의 void에 대응되는 개념이다. 하지만 이 둘이 완전히 같은 것은 아니다.
void는 반환 값이 없음을 의미하는 특수 타입이지만, Unit은 class 키워드로 정의된 일반 타입 이기 때문이다.
자바의 Void 클래스와 비슷한 개념이라고 보면 된다.

Unit을 반환하는 함수는 return을 생략한다고 해도 암묵적으로 Unit 타입의 객체를 return 하도록 되어 있다.
단, 그 Unit 객체는 싱글톤 인스턴스이기 때문에 매번 객체를 생성하지는 않는다.
 */
fun main(args:Array<String>): Unit {

    celsiusToFah(27)
    celsiusToFah2(27)
}

// 이전 예제와 이름이 겹치지 않도록 함수 이름 변경
fun celsiusToFah(celsius: Int): Unit {
    println(celsius * 1.8 + 32)
}

fun celsiusToFah2(celsius: Int) = println(celsius * 1.8 + 32)

