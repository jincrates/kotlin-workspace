package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex160_run_extension_function;

/*
160. run 확장 함수: 코드 중복 줄이기
run를 사용하면 중복되는 표현식을 하나로 묶을 수 있다.
 */
fun main(args:Array<String>): Unit {

    val a = 10
    val b = 5

    (a * b - 2 * a).run {
        if (this > 0) {
            println(this)
        }
    }
}