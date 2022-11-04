package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex070_any_class;

/*
070. Any 클래스
어떤 클래스가 아무 클래스도 상속하지 않으면 자동으로 Any라는 클래스를 상속한다.
Any 클래스에는 equals, hashCode, toString 세가지 멤버 함수가 있다.
모든 클래스는 Any 클래스를 상속하므로, 코틀린의 모든 클래스는 반드시 위의 3가지 멤버 함수를 갖는다.

- equals: == 연산자를 오버라이딩하는 멤버 함수다.
- hashCode: 객체 고유의 해시코드를 반환하는 멤버 함수이다.
- toString: 객체의 내용을 String 타입으로 변환하는 멤버 함수이다.

코드 상으로는 Any 타입의 toString 멤버 함수를 호출하고 있지만,
다형석 덕에 실제로는 building 객체의 toString()이 호출된다.
 */
fun main(args:Array<String>): Unit {
    val building = Building("코틀린", area = 100)
    printObject(building)
}

fun printObject(any: Any) {
    println(any.toString())
}