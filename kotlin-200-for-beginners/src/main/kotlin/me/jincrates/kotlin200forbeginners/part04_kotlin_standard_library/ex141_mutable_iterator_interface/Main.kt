package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex141_mutable_iterator_interface;

/*
141. MutableIterator 인터페이스 살펴보기
커서가 가리키고 있는 원소를 삭제할 수 있는 멤버 함수 remove가 추가되었다.
 */
fun main(args:Array<String>): Unit {

    val list = mutableListOf(1, 2, 3)
    val iter: MutableIterator<Int> = list.iterator()

    println(list)

    iter.next()
    iter.remove()
    println(list)

    iter.next()
    iter.remove()
    println(list)
}