package me.jincrates.kotlin200forbeginners.part01;

/*
037. 지역 변수와 전역 변수의 이름이 중복될 때
한 블록 내에서 변수의 이름은 중복될 수 없지만, 지역 변수와 전역 변수는 이름이 중복될 수 있다.
 */
var a37 = 5

fun main(args:Array<String>): Unit {
    var a37 = 30
    println(a37)
    func()

}

fun func() {
    println(a37)
}
