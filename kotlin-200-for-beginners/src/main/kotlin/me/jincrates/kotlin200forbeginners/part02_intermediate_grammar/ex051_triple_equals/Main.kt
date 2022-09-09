package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex051_triple_equals;

/*
051. ===, !== 연산자
=== 연산자는 두 참조 변수가 같은 객체를 가리키고 있는지 여부를 조사하는 연산자이다.

변수 a와 b에 똑같은 문자열 "one"을 저장하고 있다.
String 타입의 리터럴로 이루어진 표현식에 한해, 참조 변수에 동일한 문자열을 저장하면
컴파일러는 매번 새로운 문자열을 생성하지 않고 하나의 문자열을 가리키도록 만든다.

그러나 b에 "on" 문자열을 저장한 뒤, "e" 문자열을 누적하면,
똑같은 문자를 저장하고 있다고 해도 새로운 문자열이 만들어진다.
 */
fun main(args:Array<String>): Unit {

    var a = "one"
    var b = "one"
    println(a === b)

    b = "on"
    b += "e"
    println(a !== b)

    b = a
    println(a === b)
}