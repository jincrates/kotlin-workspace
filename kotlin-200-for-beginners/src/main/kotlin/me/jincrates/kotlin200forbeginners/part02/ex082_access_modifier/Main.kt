package me.jincrates.kotlin200forbeginners.part02.ex082_access_modifier;

/*
082. 접근 지정자(Access Modifier)
코틀린에서 선언 가능한 요소(함수, 전역 변수, 클래스, 프로퍼티, 멤버 함수 등) 주으 일부 요소에는
접근 권한자라는 것을 지정할 수 있다.

접근 권한자는 총 4개가 있다.
- public: 모든 곳에서 접근 가능. 접근 지정자를 생략하면 기본적으로 public이 된다.
- internal: 같은 모듈 안에서 접근 가능
- protected: 클래스 내부와 서브클래스 안에서만 접근 가능
- private: 프로퍼티와 멤버 함수일 경우, 해당 클래스 안에서만 접근 가능하고, 그 외의 경우, 같은 파일 내에서만 접근 가능
 */
class Rectangle(private val width: Int, private val height: Int) {
    val area: Int
        get() = width * height
}

fun main(args:Array<String>): Unit {
    val rect = Rectangle(5, 7)
    //println(rect.width)  //에러
    println(rect.area)
}