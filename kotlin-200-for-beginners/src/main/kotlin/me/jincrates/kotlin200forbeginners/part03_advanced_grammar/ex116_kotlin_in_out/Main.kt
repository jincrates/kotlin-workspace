package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex116_kotlin_in_out;

/*
116. in/out 키워드

AAA 클래스의 타입 매개변수 앞에 out 키워드를 붙였다.
이렇게 하면 AAA<서브 타입>을 AAA<슈퍼 타입>에 대입할 수 있게 된다.

BBB 클래스의 타입 매개변수 앞에 in 키워드를 붙였다.
이렇게 하면 BBB<슈퍼 타입>을 BBB<서브 타입>에 대입할 수 있게 된다.

타입 인수로 *를 지정하면, 타입 인수가 무엇이든 상관없이 AAA 타입을 대입할 수 있다.
즉, AAA<Any>든, AAA<Int>든, AAA<String>이든 상관없이 start 변수에 대입 가능하다.

자바의 out 키워드
out T는 자바의 ? extends T와 같다.

자바의 in 키워드
in T는 자바의 ? super T와 같다.

 */
class AAA<out T>

class BBB<in T>

fun main(args:Array<String>): Unit {

    val aaaSub = AAA<Int>()
    val aaaSuper: AAA<Any> = aaaSub

    val bbbSuper = BBB<Any>()
    val bbbSub: BBB<Int> = bbbSuper

    val star: AAA<*> = aaaSub
}