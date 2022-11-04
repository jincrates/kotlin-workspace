package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex157_string_builder_class;

/*
157. StringBuilder 클래스: 문자열 덧붙이기
 */
fun main(args:Array<String>): Unit {

    val builder = StringBuilder()
            .append("2022 ")
            .append("Twosome ")
            .append("Place")

    val result = builder.toString()
    println(result)
}