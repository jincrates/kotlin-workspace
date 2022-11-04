package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex053_this_duplication;

/*
053. 프로퍼티와 멤버 함수의 매개변수 이름이 중복될 때
멤퍼 함수의 매개변수와 프로퍼티의 이름은 중복될 수 있다.

AAA 클래스 안에 num이라는 프로퍼티가 들어있다.
memberFunction 멤버 함수의 매개변수 이름도 num이다.
보다시피 프로퍼티와 멤버 함수의 매개변수 이름을 중복해도 오류가 발생하지 ㅏㅇㄴㅎ는다.

변수 이름을 그냥 적으면 이 변수는 매개변수로 인식된다.
변수 앞에 this.를 붙이면 이 변수는 프로퍼티로 인식된다.

프로퍼티와 동일한 이름의 매개변수가 없으면 this 없이 프로퍼티 이름만 적을 수 있지만,
여기서는 이름이 동일한 매개변수가 존재하기 때문에 반드시 this.를 써야 한다.
 */
class AAA {
    var num = 15

    fun memeberFunction(num: Int) {
        println(num)
        println(this.num)
    }
}
fun main(args:Array<String>): Unit {

    val a = AAA()
    a.memeberFunction(53)
}