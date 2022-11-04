package me.jincrates.kotlinindepth.chapter05

import java.lang.IllegalArgumentException

fun sum(numbers: IntArray): Int {
    var result = numbers.firstOrNull()
            ?: throw IllegalArgumentException("Empty array")

    for (i in 1..numbers.lastIndex) {
        result += numbers[i]
    }

    return result
}

fun main() {
    println(sum(intArrayOf(1, 2, 3)))
}