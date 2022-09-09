package me.jincrates.kotlin200forbeginners.part03.ex125_sealed_class;

/*
125. sealed 클래스
sealed 클래스는 자신의 중첩 클래스에만 상속을 허용하는 클래스이다.

Outer 클래스는 자신의 중첩 또는 내부 클래스에서만 상속이 가능하다.
Outer 클래스 자체로는 인스턴스를 만들 수 없다.
 */
fun main(args:Array<String>): Unit {

    val instance: Outer = Outer.Three()

    val text: String = when (instance) {
        is Outer.One -> "첫 번째"
        is Outer.Two -> "두 번째"
        is Outer.Three -> "세 번째"
        else -> "오류"
    }

    println(text)
}