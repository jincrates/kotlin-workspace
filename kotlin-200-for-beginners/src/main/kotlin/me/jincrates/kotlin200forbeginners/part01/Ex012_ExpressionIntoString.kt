package me.jincrates.kotlin200forbeginners.part01;

/*
012. 문자열 안에 표현식의 값을 집어넣기
큰따옴표 안에 $를 적고 뒤에 변수 이름을 적으면 해당 부분은 변수의 값으로 대체된다.
변수의 값이 아닌 표현식의 값을 문자열에 포함하고 싶으면 ${표현식}을 문자열 안에 적어야 한다.
 */
fun main(args:Array<String>): Unit {

    val a = 10
    val b = 20
    println("a의 값: $a")
    println("a의 값: \$a")
    println("b의 값: $b")

    println("a + b = ${a + b}")
}