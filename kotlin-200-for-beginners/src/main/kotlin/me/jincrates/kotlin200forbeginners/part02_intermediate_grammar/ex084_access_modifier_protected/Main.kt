package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex084_access_modifier_protected;

/*
084. 접근 지정자: protected
protected 접근 지정자는 클래스 내부에서 사용된다.
 */

open class AAA(protected val number: Int)

class BBB(number: Int): AAA(number) {
    fun printNumber() {
        //AAA 클래스의 number 프로퍼티에 접근 가능
        println(number)
    }
}

fun main(args:Array<String>): Unit {

    val test = BBB(36)
    //println(test.number)  //에러
    test.printNumber()
}