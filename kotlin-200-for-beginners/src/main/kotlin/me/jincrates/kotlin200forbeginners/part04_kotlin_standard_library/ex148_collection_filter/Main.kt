package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex148_collection_filter;

/*
148. 컬렉션 중 원하는 원소 컬러내기
filter 계열의 확장 함수를 이용하면, 컬렉션 중 원하는 원소만 걸러낼 수 있다.
 */
fun main(args:Array<String>): Unit {

    val to50 = 1..50

    println(to50.filter { it % 4 == 0 })
    println(to50.filterNot { it % 4 ==0 })
    println(to50.filterNotNull())
    println(to50.filterIndexed { index, element -> element > 20 })
    println(to50.filterIsInstance<Long>())
}