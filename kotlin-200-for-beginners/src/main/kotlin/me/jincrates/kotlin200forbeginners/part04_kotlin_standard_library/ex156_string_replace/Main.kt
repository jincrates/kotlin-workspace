package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex156_string_replace;

/*
156. 문자열 찾아 바꾸기
ignoreCase는 대소문자 무시 옵션이다.
 */
fun main(args:Array<String>): Unit {

    val adage = "Love begets love."

    println(adage.replace("love", "hate", ignoreCase = true))
    println(adage.replaceFirst("love", "compliment", ignoreCase = true))
    println(adage.replaceRange(5..10, "hello"))
}