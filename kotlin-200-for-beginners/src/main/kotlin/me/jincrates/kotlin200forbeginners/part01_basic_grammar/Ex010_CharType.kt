package me.jincrates.kotlin200forbeginners.part01_basic_grammar;

/*
010. 문자 타입
 */
fun main(args:Array<String>): Unit {

    var ch: Char = 'A'
    println(ch)

    ch = '\uAC00'  // 유니코드(Unicode)
    println(ch)

    ch = '한'
    println(ch.toInt())
}