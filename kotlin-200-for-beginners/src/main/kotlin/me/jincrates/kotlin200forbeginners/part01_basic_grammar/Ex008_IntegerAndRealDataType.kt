package me.jincrates.kotlin200forbeginners.part01_basic_grammar;

/*
008. 정수와 실수 타입
컴퓨터의 저장 공간은 무한하지 않기 때문에 변수에 저장할 수 있는 값의 범위에 한계가 있다.
프로그램을 작성할 때는 항상 이를 염두에 두어야 한다.
 */
fun main(args:Array<String>): Unit {
    val a: Byte = 125
    val b: Short = (100 + 200) * 100
    var c: Int = 12_4354_6538
    c = 0xFF_88_88
    c = 0b01010010_01100011_01110101_01000101
    var d: Long = -543_7847_3984_7238_4723

    c = a + b
    d = c + 10L
    var e: Float = 67.6F
    val f: Double = 658.456
    println(e + f)
    e = (e + f).toFloat()
    println(e)
}