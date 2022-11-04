package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex133_iterable_interface;

/*
133. Iterable 인터페이스: 클래스가 반복자를 지원하도록 하기
Iterable 인터페이스는 클래스에 operator fun iterator(): Iterator<T> 연산자 멤버 함수를 주입하기 위한 인터페이스이다.
IntRange는 IntProgression과 CloseRange 인터페이스를,
LongRange는 LongProgression과 ClosedRange 인터페이스를,
CharRange는 CharProgression과 ClosedRange 인터페이스를 구현한다.

 */
fun main(args:Array<String>): Unit {

    val prog: IntProgression = 3..7
    println(prog.first)
    println(prog.last)
    println(prog.step)

    for (i in prog) {
        print("$i ")
    }
}