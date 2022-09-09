package me.jincrates.kotlin200forbeginners.part01_basic_grammar;

/*
003. 변수(Variable)
변수는 값을 저장해놓는 공간이다.(컴퓨터의 '메모리'라는 공간에 생성)

var     total :     Int
변수    변수명     변수타입
키워드  (식별자)

- 식별자는 키워드를 제외한 영문자, 숫자, 언더스코어_로만 지을 수 있다.
- 단, 숫자는 맨 앞에 오면 안 된다.
- 또한 코틀린에서는 자바와 달리 식별자에 $를 사용할 수 없다.

var와 val
- var은 일반 변수, val은 final 변수로 생각하면 된다.
- 불변 변수(Immutable Variable)의 사용을 장려하기 위해 val 키워드를 제공한다.
 */
fun main(args:Array<String>): Unit {

    var total: Int
    total = 0

    val a: Int = 10 + 53 - 7
    println(a)

    val b: Int = 43 + 75 + a
    println(b)

    total = a + b
    println(total)
}