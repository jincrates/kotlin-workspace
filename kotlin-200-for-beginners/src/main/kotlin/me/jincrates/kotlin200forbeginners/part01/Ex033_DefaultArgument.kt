package me.jincrates.kotlin200forbeginners.part01;

/*
033. 디폴트 인수
매개변수에는 디폴트 값을 지정할 수 있다. 매개변수가 너무 많아 호출하기 번거로울 때 사용하면 좋다.
 */
fun main(args:Array<String>): Unit {
    println(getAverage33(89, 96))
    getAverage33(100, 50, true)
    println(getAverage33(90))
    getAverage33(66, print = true)
    getAverage33(print = true)
    getAverage33(print = true, a = 10, b = 30)
}

fun getAverage33(a: Int = 0, b: Int = 0, print: Boolean = false): Double {
    val result = (a + b) / 2.0
    if (print)
        println(result)
    return result
}
