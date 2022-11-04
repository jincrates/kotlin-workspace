package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex149_colletion_sorted;

/*
149. 컬렉션 정렬하기
sorted 계열의 확장 함수를 이용하면 컬렉션 내의 원소를 정렬할 수 있다.
 */
fun main(args:Array<String>): Unit {

    val list = listOf(43, 76, 28, 19, 22, 68)

    println(list.sorted())
    println(list.sortedDescending())
}