package me.jincrates.kotlin200forbeginners.part02.ex064_inheritance;

/*
064. 상속(Inheritance)
상속은 기존에 존재하는 클래스를 확정하여 새로운 클래스를 정의하는 기법이다.

기본적으로 클래스는 상속이 막혀있다.
상속을 허용하려면, 클래스 정의부 앞에 open 키워드를 붙여주어야 한다.

Person처럼 상속의 대상이 되는 것을 슈퍼클래스(Superclass), Student처럼 상속하여 확장된 클래스를 서브클래스(Subclass)라고 한다.
상속을 하면 슈퍼클래스의 프로퍼티와 멤버 함수가 서브클래스에 그대로 복사된다.

상속은 하나의 클래스만 할 수 있다. 두 개 이상의 클래스는 동시에 상속이 불가능하다.
 */
open class Person(name: String, age: Int)

class Student(name: String, age: Int, val id: Int): Person(name, age)

fun main(args:Array<String>): Unit {

    val person = Person("소크라테스", 29)
    val student = Student("아리스토텔레스", 17, 20171217)
}