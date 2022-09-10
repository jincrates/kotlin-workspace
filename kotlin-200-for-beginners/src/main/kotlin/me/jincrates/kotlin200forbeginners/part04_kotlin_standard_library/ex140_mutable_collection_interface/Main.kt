package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex140_mutable_collection_interface;

/*
140. 변경할 수 있는(Mutable) 컬렉션
지금까지 살펴본 Collection, List, Map 인터페이스에는 컬렉션에 원소를 추가하거나 삭제하는 멤버 함수가 없다.
Collection 인터페이스는 컬렉션의 원소를 수정할 수 있는 방법을 제공하지 않는다.
컬렉션의 원소를 수정하려면 MutableCollection 인터페이스를 구현하는 컬렉션을 이용해야 한다.

기본적으로 Unmodifiable한 코틀린의 컬렉션
자바와 달리, 코틀린의 컬렉션은 기본적으로 수정이 불가능(Unmodifiable)하다.
덕분에 Tread-Safe한 코드를 만들 수 있게 되었다.

컬렉션을 반드시 수정해야 하는 상황이 아니라면 Mutable이 아닌 일반 Collection을 쓸 것을 권장한다.
이유는 변수 선언 시 var 대신 val을 권장으로 이유와 같다.
컬렉션을 수정할 수 있다면, 컬렉션에 들어 있는 원소와 관련되 버그가 발생했을 때
컬렉션을 어느 지점에서 수정하는지 일일이 찾아봐야 하기 때문이다.
 */
fun main(args:Array<String>): Unit {

    val mutableList: MutableCollection<Int> = mutableListOf(1, 2, 4, 2, 3, 2, 5)
    println(mutableList)

    mutableList.add(1)
    println(mutableList)

    mutableList.remove(1)
    println(mutableList)

    mutableList.removeAll(listOf(1, 2))
    println(mutableList)

    mutableList.retainAll(listOf(3, 5))
    println(mutableList)

    mutableList.clear()
    println(mutableList)
}