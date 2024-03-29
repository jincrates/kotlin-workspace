package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex093_nullable_receiver;

/*
093. Nullable 리시버
확장 함수를 응용하면, 참조 변수에 null이 지정되어 있어도 함수 호출이 가능하게 할 수 있다.
 */
fun String?.isNumber() {
    if (this == null) {
        println("문자열이 null입니다.")
    }
}

fun main(args:Array<String>): Unit {

    val empty: String? = null
    empty.isNumber()
}