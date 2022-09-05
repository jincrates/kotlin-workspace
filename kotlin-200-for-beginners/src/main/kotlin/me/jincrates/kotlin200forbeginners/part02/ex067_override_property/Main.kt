package me.jincrates.kotlin200forbeginners.part02.ex067_override_property;

/*
067. 프로퍼티를 오버라이딩하기제목()
프로퍼티에도 함수의 일종인 Getter/Setter가 존재하므로, 이들도 오버라이딩이 가능하다.
 */

open class AAA {
    open var number = 10
        get() {
            println("AAA number Getter 호출됨")
            return field
        }
        set(value) {
            println("AAA number Setter 호출됨")
            field = value
        }
}

class BBB: AAA() {
    override var number: Int
        get() {
            println("BBB number Getter 호출됨")
            return super.number
        }
        set(value) {
            println("BBB number Setter 호출됨")
            super.number = value
        }
}

fun main(args:Array<String>): Unit {
    val test = BBB()
    test.number = 5
    test.number
}