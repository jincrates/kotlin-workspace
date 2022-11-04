package me.jincrates.kotlin200forbeginners.part05_kotlin_java_together.ex191_java_to_kotlin_null_safety;

/*
191. 코틀린에서 자바 코드 접근하기: Null 안정성

 */
class KotlinClass : JavaInterface {
    override fun trim(str: String?): String =
            str?.trim() ?: ""
}
fun main(args:Array<String>): Unit {
    //val javaInterface: JavaInterface = KotlinClass()
    //println(javaInterface.trim( " hi "))
}