package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex159_to_list;

/*
159. toList 확장 함수: List 타입으로 변환하기
toList는 어떤 타입을 List 타입으로 전환하는 확장 함수이다.
 */
fun main(args:Array<String>): Unit {

    //NOTE: Pair의 타입 인수가 모두 같아야 한다.
    val list: List<Int> = Pair(10, 20).toList()

    //NOTE: Triple의 타입 인수가 모두 같아야 한다.
    val list2: List<Double> = Triple(3.1, 6.25, 8.15).toList()
}