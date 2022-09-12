package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex151_prefix_suffix;

/*
151. 접두사/접미사 관련 CharSequence 확장 함수
 */
fun main(args:Array<String>): Unit {

    val str: CharSequence = "https://www.naver.com"

    println(str.startsWith("https://"))
    println(str.endsWith(".com"))

    println(str.removePrefix("https://"))
    println(str.removeSuffix(".com"))
    println(str.removeSurrounding("https://", ".com"))
}