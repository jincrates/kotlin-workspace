package me.jincrates.kotlin200forbeginners.part03.ex109_function_literal_with_receiver;

/*
109. 리시버가 붙은 함수 리터럴
함수 리터럴에 리시버를 적용하여 확장 함수처럼 만들 수 있다.
 */
fun main(args:Array<String>): Unit {

    //Int 리시버를 [left, right] 범위 이내로 가공하여 반환하는 확장 함수
    val makeSure: Int.(left: Int, right: Int) -> Int

    makeSure = {left: Int, right: Int ->
        if (this < left) left
        else if (this > right) right
        else this
    }

    println(15.makeSure(20, 40))
    println(18.makeSure(0, 50))
    println(25.makeSure(0, 19))
}