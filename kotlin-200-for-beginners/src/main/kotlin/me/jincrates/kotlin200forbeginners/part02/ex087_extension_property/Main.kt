package me.jincrates.kotlin200forbeginners.part02.ex087_extension_property;

/*
087. 확장 프로퍼티(Extension Property)
코틀린에는 확장 프로퍼티라는 것도 존재한다.

확장 프로퍼티의 Field?
확장 프로퍼티에는 Field가 존재하지 않는다. 따라서 field 식별자는 사용할 수 없다.
 */

// 문자열의 길이가 10 이상인지 판단하는 확장 프로퍼티
val String.isLarge: Boolean
    get() = this.length >= 10

fun main(args:Array<String>): Unit {
    println("1234567890".isLarge)
    println("500 원".isLarge)
}