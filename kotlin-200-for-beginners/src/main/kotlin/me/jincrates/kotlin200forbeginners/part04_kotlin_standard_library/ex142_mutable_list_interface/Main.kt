package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex142_mutable_list_interface;

/*
142. MutableList 인터페이스 살펴보기
List는 각 원소에 순서가 있으므로, 이를 지원하는 멤버 함수가 추가되었다.
 */
fun main(args:Array<String>): Unit {

    val list: MutableList<Char> = mutableListOf('c', 'a', 'z')
    println(list)

    list.add(1, '%')
    println(list)

    list.addAll(0, listOf('L', 'P'))
    println(list)

    println(list.set(2, '/'))
    println(list)

    println(list.removeAt(4))
    println(list)
}