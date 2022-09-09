package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex124_enum_class_practice;

/*
124. 열거 클래스 활용하기
모든 열거 클래스는 자동으로 Enum이라는 클래스를 상속한다.

각 열거 상수에 존재하는 name 프로퍼티는 열거 상수의 이름을 의미하고,
ordinal은 열거 상수의 순서를 의미한다.
열거 상수의 순서는 0부터 시작한다.
 */
enum class Mode {
    SELECTION, PEN, SHAPE, ERASER
}

fun main(args:Array<String>): Unit {

    val shapeMode: Mode = Mode.SHAPE
    println(shapeMode.name)
    println(shapeMode.ordinal)

    val modes: Array<Mode> = Mode.values()
    for (mode in modes) {
        println(mode)
    }

    println(Mode.valueOf("PEN").ordinal)
}