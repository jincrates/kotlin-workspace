package me.jincrates.kotlin200forbeginners.part02.ex066_overriding;

/*
066. 오버라이딩(Overriding)
슈퍼클래스의 멤버 함수와 시그니처가 동ㅇ리한 멤버 함수를 서브클래스에서 선언하면,
슈퍼클래스 멤버 함수의 동작을 넢어쓰기할 수 있다. 이것을 오버라이딩이라고 부른다.

이제는 필수가 된 override 키워드
자바에서는 오버라이딩시 @Override 어노테이션을 붙이는 것이 옵션이지만,
코틀린에서는 override 키워드를 반드시 붙여야 한다.
자바에서는 슈퍼클래스 메서드의 시그니처나 이름이 바뀔 때 서브클래스의 함수를 같이 수정하는 것을 깜빡하여 버그를 일으키는 경우가 많았다.
하지만, 코틀린에서는 override 키워드가 강제이므로 멤버 함수를 제대로 오버라이딩하지 않을 시
오류로 알려주기 때문에 훨씬 안전한 코드를 작성할 수 있게 되었다.

멤버 함수의 재 오버라이딩을 막으려면 final 키워드를 붙여야 한다.
 */

open class AAA {
    open fun func() = println("AAA")
}

class BBB: AAA() {
    override fun func() {
        super.func()
        println("BBB")
    }
}

fun main(args:Array<String>): Unit {
    AAA().func()
    BBB().func()
}