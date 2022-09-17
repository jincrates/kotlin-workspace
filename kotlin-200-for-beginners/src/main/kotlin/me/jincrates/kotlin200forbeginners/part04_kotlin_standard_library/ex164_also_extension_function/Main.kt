package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex164_also_extension_function;

/*
164. also 함수: 객체 생성 및 초기화 코드를 표현식 하나로 압축하기
also 확장 함수는 apply와 매개변수 타입만 다를 뿐, 동일한 역할을 수행한다.
매개변수의 타입이 T.() -> Unit에서 (T) -> Unit로 바꿨을 뿐 코드는 apply와 사실상 동일하다.
 */
class Person{

    var name: String = ""
    var age: Int = 0
    var money: Int = 0

    override fun toString() = "$name $age $money"
}

fun main(args:Array<String>): Unit {

    println(
            Person().also { person: Person ->
                person.name = "Alan"
                person.money = 70
            }
    )
}