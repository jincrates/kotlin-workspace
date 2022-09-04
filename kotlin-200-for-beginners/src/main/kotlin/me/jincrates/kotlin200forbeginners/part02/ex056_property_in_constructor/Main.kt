package me.jincrates.kotlin200forbeginners.part02.ex056_property_in_constructor;

/*
056. 생성자와 프로퍼티 한번에 쓰기
 */
class Car(val name: String, val speed: Int = 0)

fun main(args:Array<String>): Unit {
    val car = Car("My Car")
    println(car.name)
    println(car.speed)
}