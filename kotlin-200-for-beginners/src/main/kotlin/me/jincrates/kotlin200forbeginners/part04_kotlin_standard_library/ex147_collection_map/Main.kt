package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex147_collection_map;

/*
147. 컬렉션 원소 타입 변환하기
 */
fun main(args:Array<String>): Unit {

    val origin = listOf(65, 66, 67, 68, 69)

    println(origin.map { it.toChar() })

    println(origin.mapIndexed { index, element ->
        println("[$index]: $element")
        element.toChar()
    })

    val to100 = 1..100
    println(to100.mapNotNull {
        if (it % 3 == 0) it
        else null
    })
}