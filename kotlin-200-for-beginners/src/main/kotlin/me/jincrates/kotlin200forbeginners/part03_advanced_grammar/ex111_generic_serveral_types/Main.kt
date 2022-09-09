package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex111_generic_serveral_types;

/*
111. 여러 타입을 인수로 받기
타입 인수를 여러 개 받으려면 fun 키워드와 함수 이름 사이를 <타입1, 타입2, ...> 형식으로 적는다.
 */
fun <T, R> T.map(mapper: (T) -> R): R {
    return mapper(this)
}

fun main(args:Array<String>): Unit {

    val square: Int =
            11.map {
                it * it
            }
    println(square)
}