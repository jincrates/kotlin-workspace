package me.jincrates.kotlin200forbeginners.part01_basic_grammar;

/*
007. 비트 연산자(Bitwise Operator) and or xor inv shl ushr
 */
fun main(args:Array<String>): Unit {
    println(15 and 7)    // 15 & 7        7
    println(5 or 2)      // 5 | 2         7
    println(15 xor 5)    // 15 ^ 2        10
    println(32767.inv()) // ~32767        -32768
    println(1 shl 3)     // 1 << 3        8
    println(8 shr 1)     // 8 >> 1        4
    println(-17 ushr 2)  // -17 >>> 2     1073741819
}