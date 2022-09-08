package me.jincrates.kotlin200forbeginners.part03.ex105_it_identifier;

/*
105. it 식별자
람다식의 매개변수가 하나일 때는 매개변수 선언을 생략할 수 있다.
매개변수를 생략하면 it이라는 특별한 식별자가 만들어진다.
여기서 it이 우리가 생략한 Int 타입의 매개변수를 대체한다.
 */
fun main(args:Array<String>): Unit {

    val instantFunc: (Int) -> Unit = {
        print("Hello $it")
    }

    instantFunc(33)
}