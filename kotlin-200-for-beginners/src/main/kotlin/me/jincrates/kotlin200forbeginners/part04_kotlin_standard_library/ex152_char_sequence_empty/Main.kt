package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex152_char_sequence_empty;

/*
152. 비어 있는 CharSequence인지 검사하기
isEmpty는 문자열이 비어 있는지, 즉 ""와 같은지 여부를 반환하는 확장 함수이다.
isBlank는 문자열이 비어 있거나 공백 문자로 이루어져 있는지 여부를 반환한느 확장 함수이다.
isNullOrEmpty은 문자열이 null이거나 비어 있는지 여부를, isNullOrBlank는 문자열이 null이거나 공백 문자로 이루어져 있는지 여부를 반환한다.
 */
fun main(args:Array<String>): Unit {

    val emptyStr = ""
    val whiteSpaces = " "
    val nullStr: String? = null

    println(emptyStr.isEmpty())
    println(whiteSpaces.isEmpty())

    println(emptyStr.isBlank())
    println(whiteSpaces.isBlank())

    println(nullStr.isNullOrEmpty())
    println(nullStr.isNullOrBlank())
}