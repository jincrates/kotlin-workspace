package me.jincrates.kotlin200forbeginners.part03_advanced_grammar.ex118_iterator;

/*
118. 반복자(Iterator)
반복자란, 특정 구간 속에 있는 원소를 하나씩 반복적으로 꺼내기 위한 인터페이스를 뜻한다.
코틀린에는 Iterator라는 인터페이스가 기본적으로 선언되어 있으며 다음과 같이 생겼다.
interface Interator<out T> {
    operator fun next(): T
    operator fun hasNext(): Boolean
}

특정 원소를 가리키는 Iterator 내부의 변수를 커서(Cursor)라고 부른다.
iter,next()는 커서를 다음 원소로 이동하고, 해당 원소를 반환한다.

참고로 hasNext가 false를 반환했는데도 next를 호출하면 NoSuchElementException 예외가 발생한다.
 */
fun main(args:Array<String>) {
    val range: IntRange = 1..3
    val iter: IntIterator = range.iterator()

    println(iter.hasNext())
    println(iter.next())

    println(iter.hasNext())
    println(iter.next())

    println(iter.hasNext())
    println(iter.next())

    println(iter.hasNext())
}