package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex077_notnull_assertion_operator;

import me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex052_member_function.Building

/*
077. Not-null 단정 연산자(Not=null Assertion Operator) !!
!! 연산자는 Nullable 타입을 Not-null 타입으로 강제로 캐스팅한다.
 */
fun main(args:Array<String>): Unit {
    var obj: Building? = Building()
    obj!!.name = "서울시청"
    println(obj!!.name)

    //obj = null
    obj!!.print()
}