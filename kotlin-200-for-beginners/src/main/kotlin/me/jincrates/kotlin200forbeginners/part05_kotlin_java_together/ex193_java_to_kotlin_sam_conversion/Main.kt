package me.jincrates.kotlin200forbeginners.part05_kotlin_java_together.ex193_java_to_kotlin_sam_conversion;

/*
193. 코틀린에서 자바 코드 접근하기: SAM 변환
SAM이란, 단일 추상 메서드(Single Abstract Method)의 줄임말로, 메서드를 한 개만 갖고 있는 인터페이스를 뜻한다.
 */
fun main(args:Array<String>): Unit {

    val runnable: Runnable = Runnable { println("SAM") }
    runnable.run()
}