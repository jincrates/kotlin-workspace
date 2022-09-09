package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex060_indexed_access_operator;

/*
060. 번호 붙은 접근 연산자(Indexed Access Operator)[]
[] 연산자는 표현식[표현식] 형태로 적으며, 객체의 일부 값을 추출해낼 때 사용한다.

person[0]은 컴파일 시 person.get(0)으로 번역된다.
 */
fun main(args:Array<String>): Unit {

    val person = Person("Kotlin", "2016-02-15")
    println(person[0])
    println(person[1])
    println(person[-1])

    person[0] = "Java"
    println(person.name)
}