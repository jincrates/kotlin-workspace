package me.jincrates.kotlin200forbeginners.part01;

/*
013. 타입 별명(Type Alias)
typealias라는 키워드를 사용하면 이미 존재하는 타입에 별명을 붙일 수 있다.
타입 별명은 타입 이름이 너무 길 때, 타입 이름을 줄이는 용도로 사용하면 좋다.
 */
typealias Number = Int

fun main(args:Array<String>): Unit {
    val a: Number = 10
    println(a)
}