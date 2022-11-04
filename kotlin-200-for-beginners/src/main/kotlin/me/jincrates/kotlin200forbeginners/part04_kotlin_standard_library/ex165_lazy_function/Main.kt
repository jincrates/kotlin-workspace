package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex165_lazy_function;

/*
165. lazy 함수: 게으른 초기화를 하는 프로퍼티 대리자
lazy 함수를 이용하면 프로퍼티의 값이 필요한 시점에 계산을 시작하게 할 수 있다.
lazy 함수는 () -> T 타입의 함수를 받는다. 이따 반환 타입 Lazy<T>는 프로퍼티를 대리하는 클래스이다.

게으른 초기화는 수표와 비슷하다. 수표는 지금 당장 갖고 있는 현금(데이터)은 아니지만,
필요한 순간에 실제 돈으로 가져올(게으른 초기화) 수 있기 때문이다.
물론, 현실에서는 게으른 초기화가 항상 성공한다는 보장이 없다.(부도)

게으론 초기화라는 개념이 있으면, 무한대의 데이터를 표현하는 등, 실제로 가지고 있지도 않은 데이터를 지금 당장 갖고 있는 것처럼 과장할 수 있다.
데이터를 요구할 때만 값을 계산하여 주면 되기 때문이다.

게으른 초기화의 유용성
게으른 초기화는 프로퍼티가 힙 영역에 할당되는 순간 바로 이루어지는 것이 아니기 때문에 다음과 같은 상황에 유용하다.
val view: View? by lazy { findViewById(R.id.view) }
액티비티의 findViewById는 setContentView가 호출되기 전에 무조건 null을 반환한다.
따라서 프로퍼티를 선언과 동시에 초기화하면 안 된다.
그러나, 프로퍼티를 val로 선언하고 싶으면 반드시 선언과 동시에 초기화해야 한다.
이때, 프로퍼티의 초기화를 Lazy<T>에 위임하고, setContentView를 수행하고 난 뒤 view 프로퍼티에 접근하면,
그제서야 view 프로퍼티를 findViewById(R.id.view)로 초기화하므로 제대로 View 인스턴스를 가져올 수 있다.
 */
class AAA {
    var num: Int = 0
    val num2 by lazy { num * 5 }
}

fun main(args:Array<String>): Unit {

    val one = AAA()
    println(one.num2)
    one.num = 10
    println(one.num2)

    val two = AAA()
    two.num = 4
    println(two.num2)
}