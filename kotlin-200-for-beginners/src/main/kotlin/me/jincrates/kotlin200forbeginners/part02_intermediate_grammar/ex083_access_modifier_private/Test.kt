package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex083_access_modifier_private;

/*
083. 접근 지정자: private
 */

private var num = 10 //Test.kt 파일 내에서만 접근 가능

private fun print() //Test.kt 파일 내에서만 접근 가능
    = println(num)

public fun hello(value: Int) {  // 어디에서나 접근 가능
    num = value
    print()
}

public class Person(age: Int) {  // 어디에서나 접근 가능

    // 디폴트 Setter를 private으로 지정. Setter는 Person 클래스 내부에서만 접근 가능
    public var age = age
        private set

    // Getter를 public으로 지정. Getter는 어디에서나 접근 가능
    public val isYoung public get() = age < 30
}