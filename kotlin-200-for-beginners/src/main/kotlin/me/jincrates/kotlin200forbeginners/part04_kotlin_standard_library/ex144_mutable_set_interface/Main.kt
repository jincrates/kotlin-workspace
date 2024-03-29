package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex144_mutable_set_interface;

/*
144. MutableSet 인터페이스 살펴보기
mutableSetOf 함수를 호출하면 MutableSet<E> 타입의 객체가 반환된다.
MutableSet<E> 인터페이스는 MutableCollection<E>를 상속한다.
 */
fun main(args:Array<String>): Unit {

    val set: MutableSet<Int> = mutableSetOf(1, 5, 7)
    println(set)

    println(set.add(5))
    println(set)

    println(set.addAll(listOf(3, 7)))
    println(set)
}