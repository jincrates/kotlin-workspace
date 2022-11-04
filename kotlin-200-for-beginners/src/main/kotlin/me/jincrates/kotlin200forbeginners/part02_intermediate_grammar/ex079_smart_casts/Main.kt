package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex079_smart_casts;

/*
079. 스마트 캐스팅
특정 조건을 만족하는 경우, 컴파일러는 변수의 타입을 다른 타입으로 자동 캐스팅한다.
이를 스마트 캐스팅이라고 부른다.
 */
fun main(args:Array<String>): Unit {

    val number: Int? = null
    val number2 = 1225

    checkNull(number)
    checkNull(number2)
}

fun checkNull(any: Any?) {

    if (any == null) {
        println("null이 들어왔습니다.")
        return
    }

    println(any.toString())
}