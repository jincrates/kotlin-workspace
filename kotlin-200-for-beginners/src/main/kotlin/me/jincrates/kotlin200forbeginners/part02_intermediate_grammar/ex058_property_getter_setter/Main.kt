package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex058_property_getter_setter;

/*
058. 프로퍼티와 Getter/Setter
우리는 프로퍼티를 클래스에 묶이는 변수라고 배웠다.
그러나 프로퍼티에는 변수뿐만 아니라 Getter/Setter라고 부르는 특수 함수도 포함되어 있다.

프로퍼티는 실제로 데이터가 저장되는 공간(Field),
저장된 값을 읽으려고 할 때 호출되는 함수(Getter),
그리고 값을 저장하려고 할 때 호출되는 함수(Setter)로 이루어져 있다.

val 프로퍼티의 Setter?
val 프로퍼티는 초기 값이 주어지면 더 이상 값을 변경(Set)할 수 없다.
그래서 val 프로퍼티에는 Getter만 존재한다.
val 프로퍼티에 Setter를 정의하려고 하면 오류가 발생한다.

디폴트 Getter/Setter의 유용성
프로퍼티에 디폴트 Getter/Setter가 포함되어 있기 떄문에 더 이상 자바처럼 Getter/Setter를 마구 만들 필요가 없다!
단, Getter/Setter의 동작을 커스터마이징 하고 싶다면 별도로 정의해 주어야 한다.
 */
fun main(args:Array<String>): Unit {

    val person = Person()
    person.age = -30
    println(person.age)
}