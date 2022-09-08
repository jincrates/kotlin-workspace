package me.jincrates.kotlin200forbeginners.part03.ex091_const;

/*
091. const
inline 함수와 비슷하게, val 변수 앞에 const 키워드를 붙이면 변수에 접근하는 코드를 변수에 저장된 값으로 대체시킨다.
const 키워드는 전역 변수, 오브젝트의 프로퍼티 등에 붙일 수 있다.
프로그램 어디서나 바로 접근할 수 있는 변수에 붙일 수 있다고 생각하면 된다.

const 키워드의 활용
const 키워드는 어디에 활용할 수 있을까? 아직 소개하지는 않았지만, 코틀린 문법 중에는 리터럴만 와야하는 자리가 몇 군데 있다.
const 키워드가 붙은 변수는 리터럴로 대체되므로, 이런 곳에 사용하면 좋다.
 */
const val hello = "Hello" + " Kotlin!"

object Foo {
    const val bar = "bar"
}

fun main(args:Array<String>): Unit {

    println(hello)
    println(Foo.bar)
    println(hello)
    println(Foo.bar)
}