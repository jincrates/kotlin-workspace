package me.jincrates.kotlin200forbeginners.part02.ex069_object_extends_class;

/*
069. 클래스를 상속하는 객체
클래스 없이 객체를 만들 때 쓰는 object 표현식으로도 상속을 할 수 있다.
 */
open class Person(val name: String, val age: Int) {
    open fun print() {
        println("이름: $name")
        println("나이: $age")
    }
}
fun main(args:Array<String>): Unit {

    val custom: Person = object: Person("Alan", 23) {
        override fun print() {
            println("It's a object")
        }
    }

    custom.print()
}