package me.jincrates.kotlin200forbeginners.part02.ex085_access_modifier_overriding;

/*
085. 접근 지정자 오버라이딩
오버라이딩을 통해 protected인 프로퍼티나 멤버 함수의 접근 지정자를 public으로 변경할 수 있다.

오버라이딩이 불가능한 private 접근 지정자
private인 프로퍼티와 멤버 함수는 서브클래스에서 접근이 불가능하기 때문에 오버라이딩할 수 없다.
사실, private인 프로퍼티와 멤버 함수에는 open 키워드 자체를 지정할수 없다.
 */
open class AAA(protected open val number: Int) {
    protected open fun hello() {
        println("hello")
    }
}

class BBB(number: Int): AAA(number) {
    public override val number: Int
        get() = super.number

    public override fun hello() = super.hello()
}

fun main(args:Array<String>): Unit {

    val b = BBB(26)
    val a: AAA = b

    //println(a.number)  //에러
    //a.hello()  //에러
    println(b.number)
    b.hello()
}