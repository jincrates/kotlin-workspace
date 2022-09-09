package me.jincrates.kotlin200forbeginners.part03.ex121_array_to_vararg;

/*
121. 배열을 가변 인수로 활용하기
배열 속에 들어 있는 원소들은 가변 인수로 활용할 수 있다.
배열 앞에 *을 찍으면 배열 속의 내용을 가변 인수로 활용할 수 있다.
 */
fun printAll(vararg tokens: String) {
    for (token in tokens) {
        print("$token ")
    }
}

fun main(args:Array<String>): Unit {

    val numbers: Array<String> = arrayOf("What's", "your", "name?")
    printAll(*numbers)
}