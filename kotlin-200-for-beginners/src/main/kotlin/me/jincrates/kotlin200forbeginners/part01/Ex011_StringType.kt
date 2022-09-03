package me.jincrates.kotlin200forbeginners.part01;

/*
011. 문자열(String)
 */
fun main(args:Array<String>): Unit {

    var str: String = "Hello"
    println(str)

    str = str + "\nKotlin!"
    println(str)

    println(str[8])

    val num = 10 * 5 + 3
    println(str + num)
}