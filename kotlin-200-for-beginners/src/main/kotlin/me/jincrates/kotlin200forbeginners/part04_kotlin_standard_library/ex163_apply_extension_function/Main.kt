package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex163_apply_extension_function;

/*
163. apply 함수: 객체 생성 및 초기화 코드를 표현식 하나로 압축하기
함수 내부를 보면, T.() -> Unit 타입의 함수를 block 매개변수로 받은 뒤 곧바로 호출하고, return this를 통해 apply의 리시버를 그대로 반환한다.
 */
class Person {

    var name: String = ""
    var age: Int = 0
    var money: Int = 0

    override fun toString() = "$name $age $money"
}

fun main(args:Array<String>): Unit {

    println(
            Person().apply {
                this.name = "Alan"
                this.money = 70
            }
    )
}