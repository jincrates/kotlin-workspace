package me.jincrates.kotlin200forbeginners.part02.ex054_constructor;

/*
054. 생성자(Constructor)와 초기화(Initializer) 블록
생성자는 객체를 초기화하는 특수 멤버 함수이다.
생성자를 사용하면 객체를 생성하고 난 뒤 프로퍼티에 값을 채워넣는 번거로운 작업을 줄일 수 있다.

코틀린의 생성자
코틀린의 생성자는 자바의 생성자와 달리 매우 특이하게 생겼다.
어차피 생성자의 이름과 클래스의 이름은 동일하므로,
코틀린에서는 생성자 정의부를 아예 이름에 합쳐버렸기 때문이다.
 */
class Person constructor(name: String, age: Int) {
    val name: String
    val age: Int

    init {
        this.name = name
        this.age = age
    }
}
fun main(args:Array<String>): Unit {

    val person = Person("소크라테스", 29)
    println("이름: ${person.name}")
    println("나이: ${person.age}")
}