package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex182_kotlin_version;

/*
182. KotlinVersion 클래스: 사용 중인 코틀린 버전 알아내기
 */
fun main(args:Array<String>): Unit {
    val kotlinVersion: KotlinVersion = KotlinVersion.CURRENT
    println("${kotlinVersion.major}, ${kotlinVersion.minor}, ${kotlinVersion.patch}")
    println(kotlinVersion.isAtLeast(1, 1, 0))
}