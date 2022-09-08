package me.jincrates.kotlin200forbeginners.part03.ex099_nested_class;

/*
099. 중첩 클래스(Nested Class)
클래스 안에는 또 다른 클래스를 선언할 수 있다.

중첩된 클래스는 타입 이름이 ]바깥 클래스.중첩 클래스]로 만들어진다.
생성자 이름도 마찬가지이다.

Nested 클래스는 Nested라는 식별자만 Outer 클래스에 속해있을 뿐, 실제로는 완전히 분리된 장소게 있다.
따라서 Nested 클래스의 멤버 함수는 Outer 클래스의 프로퍼티나 멤버 함수에 접근할 수 없다.

Outer의 인스턴스와 Outer.Nested의 인스턴스는 서로 어떠한 프로퍼티나 멤버 함수도 공유하지 않는다.
완전히 별개의 클래스이다.
 */
class Outer {  // 바깥 클래스

    class Nested {  // 중첩 클래스
        fun hello() = println("중첩된 클래스")
    }
}
fun main(args:Array<String>): Unit {
    val instance: Outer.Nested = Outer.Nested()
    instance.hello()
}