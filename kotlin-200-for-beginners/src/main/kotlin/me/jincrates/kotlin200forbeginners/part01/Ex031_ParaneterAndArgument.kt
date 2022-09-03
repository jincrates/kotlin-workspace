package me.jincrates.kotlin200forbeginners.part01;

/*
031. 매개변수(Parameter)와 인수(Argument)
함수는 고정된 문장으로 이루어져 있기 때문에 기본적으로 다양한 기능을 기대할 수 없다.
하지만, 함수에 값ㅇ르 전달하면 함수가 다양한 일을 수행할 수 있게 만들 수 있다.

- 매개변수(Parameter)는 함수를 호출한 곳으로부터 값을 전달받을 때 사용한다.
- 인수(Argument)는 매개변수에 저장되는 표현식을 말한다. '
 */
fun main(args:Array<String>): Unit {
    println(cToF(30))
    println(getAverage(89, 96))

}

fun cToF(celsius: Int): Double {
    return celsius * 1.8 + 32
}

fun getAverage(a: Int, b: Int): Double {
    return (a + b) / 2.0
}

