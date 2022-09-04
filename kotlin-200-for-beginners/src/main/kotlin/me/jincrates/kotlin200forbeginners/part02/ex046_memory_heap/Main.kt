package me.jincrates.kotlin200forbeginners.part02.ex046_memory_heap

/*
046. 메모리의 힙(Heap) 영역
아래 예제에서 person 변수를 선언과 동시에 객체로 초기화 하고 있다.
이때 변수의 선언이 먼저 이루어지므로, 처음에는 스택에 person 변수가 쌓일 것이다.
그 다음 object{...} 부분이 실행되어 힙 영역에 객체가 생성된다.

변수가 차곡차곡 쌓이는 형태인 스택 영역과 달리, 힙 영역에는 임의의 위치에 객체가 생성된다.
따라서 어떤 객체의 프로퍼티에 값을 저장하거나 저장된 값을 가져오고 싶으면, 그 객체의 힙 영역상 좌표를 알고 있어야 한다.

object{...} 표현식은 힙 영역에 객체를 생성하며, 갓 생성된 객체의 좌푯값을 갖는다.
person 변수에는 객체의 좌표를 저장하기 위한 공간만 존재한다.
person처럼 실제 값을 가지지 않고 객체의 좌표만 저장하는 변수를 참조 변수(Reference Variable)라고 한다.
객체의 좌표값은 참조값(Reference Value)이라고 부른다.

앞으로 참조 변수가 어떤 객체의 참조값을 저장하고 있는 것을 '참조 변수가 해당 객체를 가리킨다'라고 표현하겠다.

 */
fun main(args:Array<String>): Unit {

    val person = object {
        val name: String = "홍길동"
        val age: Int = 29
    }

    println(person.name)
    println(person.age)
}