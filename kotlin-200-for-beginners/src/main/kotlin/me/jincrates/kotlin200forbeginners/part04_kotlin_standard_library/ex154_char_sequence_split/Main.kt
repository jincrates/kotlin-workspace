package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex154_char_sequence_split;

/*
154. CharSequence 쪼개기
 */
fun main(args:Array<String>): Unit {

    val hello: CharSequence = "안녕하세요.\n고맙습니다.\n반갑습니다."
    val time: CharSequence = "2022-09-13"

    println(hello.lines())
    for (line in hello.lineSequence()) {
        println(line)
    }
    println(time.split('-'))
}