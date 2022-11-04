package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex076_safe_call_operator;

import me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex052_member_function.Building

/*
076. 안전한 호출 연산자(Safe Call Operator) ?.
Nullable한 참조 변수의 프로퍼티와 멤버 함수에 접근하려면 . 대신 ?. 연산자를 반드시 사용해야 한다.
?.은 null 값에 안전한 연산자이다.
참조 변수가 null이면 참조 변수 ?. 프로퍼티 표현식이 null 값을 갖게 된다.
 */
fun main(args:Array<String>): Unit {
    var obj: Building? = null
    obj?.print()
    obj?.name = "건물"

    obj = Building()
    obj?.name = "서울월드컵경기장"
    obj?.date = "2001년 11월 10일"
    obj?.area = 21_6712
    obj?.print()
}