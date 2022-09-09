package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex120_array;

/*
120. 배열(Array)
배열은 타입이 같은 변수를 여러 개 만들 때 사용한다.
 */
fun main(args:Array<String>): Unit {

    val integers: Array<Int> = arrayOf(10, 20, 30, 40)

    println(integers.size)
    println(integers[1])

    for (i in integers) {
        print("$i ")
    }
}