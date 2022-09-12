package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex150_char_sequence_interface;

/*
150. CharSequence 인터페이스: 문자열과 관련된 클래스가 구현하는 뼈대 인터페이스
 */
fun main(args:Array<String>): Unit {
    val seq: CharSequence = "Hello"
    println(seq.length)
    println(seq[2])
    println(seq.subSequence(1, 4))
}