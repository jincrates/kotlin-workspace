package me.jincrates.kotlin200forbeginners.part03.ex123_enum_class_members;

/*
123. 열거 클래스에 프로퍼티와 멤버 함수 선언하기
열거 클래스도 클래스의 일종이기 때문에 프로퍼티와 멤버 함수를 가질 수 있다.
열거 클래스에 생성자가 있으면, 열거 상수 각각에 (인수)를 적어 생성자를 호출해야 한다.
열거 상수 각각이 열거 클래스의 인스턴스라고 생각하면 된다.

마지막 열거 상수에는 끝에 세미콜론 ;을 반드시 붙여야 한다.
열거 클래스의 프로퍼티와 멤버 함수는 반드시 열거 상수 나열문 보다 뒤에 와야 한다.
 */
enum class Mode(val number: Int) {
    SELECTION(0),
    PEN(1),
    SHAPE(2),
    ERASER(3);

    fun printNumber() {
        println("모드: $number")
    }
}

fun main(args:Array<String>): Unit {

    // 현재 선택된 모드
    val mode: Mode = Mode.ERASER

    println(mode.number)
    mode.printNumber()
}