package me.jincrates.kotlin200forbeginners.part03.ex089_companion_object;

/*
089. 동반자 객체(Companion Object)
동반자 객체는 클래스 안에 포함된 이름 없는 객체이다.
어떤 클래스의 모든 인스턴스가 공유하는 객체를 만들고 싶을 때 사용한다.

동반자 객체를 정의할 때는 이름 없이 companion object라고만 적는다.

동반자 객체에 접근하는 또 다른 방법
어떤 클래스 안에 동반자 객체를 정의해놓으면 Companion이라는 식별자가 자동으로 생긴다.
따라서 Person.create()는 Person.Companion.create()로도 호출할 수 있다.

static을 대체하는 동반자 객체
코틀린에는 static 키워드가 더 이상 존재하지 않는다.
따라서 static의 효과를 얻고 싶으면 동반자 객체를 사용해야 한다.
 */
class Person private constructor() {

    companion object {
        fun create(): Person {
            countCreated += 1
            return Person()
        }

        var countCreated = 0
            private set
    }
}

fun main(args:Array<String>): Unit {

    val a = Person.create()
    val b = Person.create()
    println(Person.countCreated)
}