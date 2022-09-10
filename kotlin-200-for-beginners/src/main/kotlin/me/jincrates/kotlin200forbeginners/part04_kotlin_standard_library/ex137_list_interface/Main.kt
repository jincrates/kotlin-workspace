package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex137_list_interface;

/*
137. List 인터페이스 살펴보기
 */
fun main(args:Array<String>): Unit {

    val list: List<Double> = listOf(20.18, 1.14, 9.15, 1.14)

    println(list[0])
    println(list.indexOf(1.14))
    println(list.indexOf(9.31))
    println(list.lastIndexOf(1.14))
    println(list.subList(0, 3))  // 0 ~ 2번 인덱스에 해당하는 원소를 뽑아 새 List를 만든 뒤, 출력
}