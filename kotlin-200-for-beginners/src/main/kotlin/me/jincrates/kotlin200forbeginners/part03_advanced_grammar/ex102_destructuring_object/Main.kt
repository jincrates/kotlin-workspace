package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex102_destructuring_object;

/*
102. 객체 분해하기
데이터 클래스의 인스턴스에 한해, 객체를 여러 개의 변수로 쪼개는 것이 가능하다.

Employee 타입의 표현식을 여러 변수로 쪼갤 수 있다.
어떤 객체에서 필요한 부분만 변수로 추출할 때 이 문법을 사용하면 좋다.
사용되지 않는 변수의 이름은 언더스코어(_)를 지정하여 무시할 수 있다.
 */

data class Employee(val name: String, val age: Int, val salary: Int)

fun main(args:Array<String>): Unit {

    val(name, _, salary) = Employee("John", 30, 3300)
    println(name); println(salary)
}