package me.jincrates.kotlin200forbeginners.part01;

/*
040. 메모리의 스택(Stack) 영역
메모리에는 스택(Stack)이라고 하는 영역이 있다. 이곳에 지역 변수가 저장된다.
스택은 '쌓아올리다'라는 뜻으로, 변수가 생성될 때 생성된 순서대로 차곡차곡 쌓이기 때문에
이런 이름이 붙었다.

main 함수가 시작되면서 매개변수 args가 생성된다.
지역 변수 a를 선언하고 absolute 함수가 호출되면서 매개변수 number가 생성된다.
absolute 호출이 끝나면서 매개변수 number가 스택 영역에서 사라진다.
다시 지역변수 result가 스택 영역에 쌓이고 main 함수가 끝나면서
모든 지역 변수가 스택 영역에서 사라진다.
 */
fun main(args: Array<String>): Unit {
    val a = -36
    val result = absolute(a)
    println(result)
}

fun absolute(number: Int): Int {
    return if (number >= 0) {
        number
    } else {
        -number
    }
}
