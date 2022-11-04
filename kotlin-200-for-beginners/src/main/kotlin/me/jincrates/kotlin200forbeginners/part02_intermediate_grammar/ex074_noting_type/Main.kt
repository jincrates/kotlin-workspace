package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex074_noting_type;

/*
074. Nothing 타입
Nothing 타입은 실행 흐름이 도달할 수 없는 구역을 나타내기 위한 특수 타입이다.
throw Exception() 표현식은 Nothing 타입을 갖는다.
 */
fun throwing(): Nothing = throw  Exception()

fun main(args:Array<String>): Unit {
    println("start!")

    validate(-1)

    val i: Int = throwing()
    println(i)
}

fun validate(num: Int) {
    val result: Int =
        if(num >= 0 ) num
        else throw Exception("num이 음수입니다.")
}