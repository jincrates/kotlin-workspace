package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex158_regex_class;

/*
158. Regex 클래스: 정규식 다루기
Regex.replace() : 정규식에 매칭되는 부분을 치환한다.
 */
fun main(args:Array<String>): Unit {

    val regex = Regex("[0-9]+")
    val str = "4324235"
    val str2 = "324 6546 5432"

    println(regex matches str)
    println(regex matches str2)
    println(regex.replace(str2, "숫자"))
}