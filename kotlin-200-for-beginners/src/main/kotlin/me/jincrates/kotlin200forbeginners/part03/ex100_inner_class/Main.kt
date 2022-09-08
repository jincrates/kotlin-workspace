package me.jincrates.kotlin200forbeginners.part03.ex100_inner_class;

/*
100. 내부 클래스(Inner Class)
중첩 클래스(Nested Class)가 단순히 식별자만 바깥 클래스에 속해있는 것이었다면,
내부 클래스는 인스턴스가 바깥 클래스의 인스턴스에 완전히 소속된다.

내부 클래스의 인스턴스를 생성하려면 [클래스 이름.생성자()]가 아닌 [참조 변수.생성자()]를 해야 한다.
내부 클래스는 바깥 클래스의 인스턴스로부터만 생성할 수 있기 때문이다.

내부 클래스는 this@Outer 키워드를 이용하여 자신이 속한 바깥 클래스의 인스턴스에 접근할 수 있다.
이런 특성 때문에, 내부 클래스 인스턴스는 반드시 바깥 클래스의 인스턴스.생성자() 꼴로 생성해야 한다.
 */
class Outer(private val value: Int) {

    fun print() {
        println(this.value)
    }

    inner class Inner(private val innerValue: Int) {

        fun print() {
            this@Outer.print()
            println(this.innerValue + this@Outer.value)
        }
    }
}
fun main(args:Array<String>): Unit {

    val instance: Outer = Outer(610)
    val innerInstance: Outer.Inner = instance.Inner(40)
    innerInstance.print()
}