package me.jincrates.kotlin200forbeginners.part01_basic_grammar;

/*
034. 가변 인수
매개변수 앞에 vararg 키워드를 붙이면 여러 개의 인수를 받을 수 있게 된다.
 */
fun main(args:Array<String>): Unit {
    println(getSumOf(1, 2, 3, 4, 5, 6, 7))
    println(getSumOf(32, 57, 12))
    println(getSumOf())
}

fun getSumOf(vararg numbers: Int): Int {
    val count = numbers.size;
    var i = 0
    var sum = 0

    while(i < count) {
        sum += numbers[i]
        i += 1
    }

    return sum
}
