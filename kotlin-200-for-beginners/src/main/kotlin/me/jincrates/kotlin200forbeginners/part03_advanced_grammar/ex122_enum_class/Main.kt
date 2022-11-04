package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex122_enum_class;

/*
122. 열거 클래스(Enum Class)
그림판 프로그램을 만든다고 가정해보자.
그림판에는 선택 모드, 펜 모드, 도형 모드, 지우개 모드 등 여러 가지 모드가 있다.
현재 선택된 모드를 저장하려면 어떻게 해야 할까?
선택 모드 = 0, 펜 모드 = 1, 도형 모드 = 2, 지우개 모드 = 3 이런 식으로 나름의 규칙을 정한 뒤,
Int 타입 변수에 저장하는 방법이 있을 것이다.
그러나, 이 방법은 각 숫자의 의미를 항상 기억하고 있어야 하고,
실수나 오타로 지정된 범위 바깥의 값(4, 5 등)을 지정하여 버그를 일으킬 수 있다.
따라서, Int 타입 변수 보다는 열거 클래스를 사용하는 것이 좋다.

열거 클래스를 선언하려면 클래스 선언문 앞에 enu, 키워드를 붙인다.
열거 클래스에 포함시킬 식별자를 쉼표를 이용해 나열한다.
식별자는 모두 대문자로 하는 것이 좋다.

열거 상수
열거 클래스에 들어가는 식별자를 열거 상수(Enum Constant)라고 한다.
 */
enum class Mode {
    SELECTION, PEN, SHAPE, ERASER
}

fun main(args:Array<String>): Unit {

    // 현재 선택된 모드
    val mode: Mode = Mode.PEN

    when (mode) {
        Mode.SELECTION -> println("선택 모드")
        Mode.PEN -> println("펜 모드")
        Mode.SHAPE -> println("도형 모드")
        Mode.ERASER -> println("지우개 모드")
    }
}