package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex081_downcasting;

import me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex065_upcasting.Person
import me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex065_upcasting.Student

/*
081. as 연산자와 다운 캐스팅
다운캐스팅은 업캐스팅과는 반대로 슈퍼클래스 타입을 서브클래스 타입으로 받는 것을 뜻한다.

캐스팅에 실패했을 때 예외가 발생하는 것을 막고 싶으면 as? 연산자를 대신 사용해야 한다.
as? 연산자는 캐스팅에 실패하면 null을 돌려준다.
 */
fun main(args:Array<String>): Unit {

    val person: Person = Student("John", 32, 20171218)
    val person2: Person = Person("Jack", 29)

    var person3: Student = person as Student
    //person3 = person2 as Student  //ClassCastException 예외 발생
}