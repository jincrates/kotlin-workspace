package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex161_let_extension_function;

/*
161. let 확장 함수: 코드 중복 줄이기
let 확장 함수도 매개변수의 타입만 다를 뿐, run과 거의 유사한 역할을 한다.
let은 block 매개변수로 (T) -> R 타입의 함수를 받는다.
 */
fun main(args:Array<String>): Unit {
    val a = 10
    val b = 5

    (a * b - 2 * a).let { result:Int ->
        if (result > 0) {
            println(result)
        }
    }
}