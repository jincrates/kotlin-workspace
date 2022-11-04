package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex143_mutable_list_iterator_interface;

/*
143. MutableListlterator 인터페이스 살펴보기
MutableList<Int> 타입의 list 변수로부터 MutableListIterator<Int>를 얻어내고 있다.
MutableList의 listIterator 멤버 함수는 ListIterator가 아닌 MutableListIterator을 반환한다.
 */
fun main(args:Array<String>): Unit {

    val list = mutableListOf(1, 2, 3)
    val iter: MutableListIterator<Int> = list.listIterator()

    println(list)

    iter.next()
    iter.next()
    iter.add(7)
    println(list)

    iter.next()
    iter.set(10)
    println(list)
}