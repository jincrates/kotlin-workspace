package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex052_member_function;

/*
052. 멤버 함수(Member Function)
클래스에 내장된 함수를 멤버 함수라고 부른다.
객체는 동작(Behavior)도 갖는다고 했는데, 멤버 함수가 바로 객체의 동작 역할을 한다.

코틀린의 모든 타입은 클래스
코틀린에 존재하는 모든 타입은 클래스이다.
즉, Byte, Short, Int, Long, Float, Double, Char, Boolean 같이
스택에 실제 값이 저장되는 타입들도 모두 클래스이다.

기본 타입이 클래스로 선언된 것은,
기본 타입에서 호출할 수 있는 멤버 함수를 코틀린 문법적으로 확실히 하기 위한 장치일 뿐,
그 자체로 어떤 코드를 담고 있는 것은 아니다.
즉, 기본 타입은 클래스의 형태는 하고 있어도 사용자 정의 클래스와는 엄연히 다르다.
 */
fun main(args:Array<String>): Unit {
    //building 객체. 정확히 말하면 building 참조 변수가 가리키는 인스턴스를 말한다.
    val building = Building()
    building.name = "A 빌라"
    building.date = "2017-12-13"
    building.area = 120 * 8

    building.print()
}