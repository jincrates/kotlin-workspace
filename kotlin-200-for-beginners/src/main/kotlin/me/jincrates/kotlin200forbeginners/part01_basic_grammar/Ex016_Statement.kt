package me.jincrates.kotlin200forbeginners.part01_basic_grammar;

/*
016. 문장(Statement)
문장(Statement)은 독립적으로 실행할 수 있는 코틀린 코드 조각을 뜻한다.
문장은 독립적인 코드 조각을 세는 단위기 떄문에 표현식과는 조금 다르다.
표현식은 하나의 값으로 수렴하는 덩어리이기만 하면 성립하지만,
문장은 더 이상 다른 코드와 연결되지 않는 독립체를 뜻하기 때문에
문장은 표현식이 아닐 수 있다.
 */
fun main(args:Array<String>): Unit {

    val num: Int
    num = 15

    println(
        num + 7 * 3
    )
}