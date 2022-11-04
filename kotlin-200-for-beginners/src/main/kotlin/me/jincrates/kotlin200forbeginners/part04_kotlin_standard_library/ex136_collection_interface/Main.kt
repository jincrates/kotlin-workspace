package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex136_collection_interface;

/*
136. Collection 인터페이스 살펴보기

 */
fun main(args:Array<String>): Unit {

    val list: Collection<Int> = listOf(18, 1, 1, 4)

    println(list.size)
    println(list.isEmpty())
    println(18 in list)

    for (i in list) {
        print("$i ")
    }
}