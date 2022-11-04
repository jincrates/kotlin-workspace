package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex153_trim_char_sequence;

/*
153. CharSequence 가공하기
 */
fun main(args:Array<String>): Unit {

    val str = " hello "

    println(str.removeRange(0..5))

    println(str.padStart(20, '*'))
    println(str.padEnd(17, '*'))

    println(str.trimStart())
    println(str.trimEnd())
    println(str.trim())

    println(str.slice(4..6))
    println(str.subSequence(4..6))
    println(str.substring(4..6))

    println(str.reversed())
}