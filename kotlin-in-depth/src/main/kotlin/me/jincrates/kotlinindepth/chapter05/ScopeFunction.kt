package me.jincrates.kotlinindepth.chapter05


/*
[스코프 함수]
코틀린 표준 라이브러리에는 어떤 식을 계산한 값을 문맥 내부에서 임시로 사용할 수 있도록 해주는 몇 가지 함수가 들어 있다.
때로는 지역 변수를 명시적으로 선언하지 않고, 식의 값이 들어 있는 암시적인 영역을 정의해서 코드를 단순화할 수 있는 경우가 있다.
이런 함수를 보통 스코프 함수라고 부른다.

전체적으로는 run, let, with, apply, also라는 다섯까지 표준 영역 함수가 있다.
모든 스코프 함수는 인라인 함수이기 때문에 런타임 부가 비용이 없다.

스코프 함수는 조심히 사요해야 하며, 남용하면 오히려 코드 가독성이 나빠지고 실수하기도 쉬워진다는 점을 명시하라.
일반적으로 여러 영역 함수를 내포시키면 this나 it이 어떤 대상을 가리키는지 구분하기 어려워지므로 \
영역 함수를 여러 겹으로 내포시켜 사용하지 않는 편을 권장한다.
 */
class Address(
    var zipCode: Int = 0,
    var city: String = "",
    var street: String = "",
    var house: String = ""
) {
    fun post(message: String): Boolean {
        "Message for {$zipCode, $city, $street, $house}: $message"
        return readln() == "OK"
    }
}

fun Address.showCityAddress() = println("run(): $street, $house")

fun main() {
    /*
    [run 함수]
    확장 람다를 받은 확장 함수이며 람다의 결과를 돌려준다.
    기본적인 사용 패턴은 객체 상태를 설정한 다음,
    이 객체를 대상으로 어떤 결과를 만들어 내는 람다를 호출하는 것이다.
    */
    Address().run {
        // Address 인스턴스를 this로 사용할 수 있다
        zipCode = 123456
        city = "London"
        street = "Baker Street"
        house = "221b"
        showCityAddress()
    }

    /*
    [with 함수]
    with 함수는 run()과 상당히 비슷하지만, 확장 함수 타입이 아니므로,
    문맥 식을 with의 첫 번째 인자로 전달해야 한다.
    객체 타입의 중복 사용을 제거할 수 있다.
    */
    val message = with (Address(city = "London", street =  "Baker Street", house = "221b")) {
        "with(): Address: $city, $street, $house"
    }
    println(message)


    /*
    [let 함수]
    let 함수는 run()과 비슷하지만 확장 함수 타입의 람다를 받지 않고 인자가 하나뿐인 함수 타입의 람다를 받는다는 점이 다르다.
    따라서 문맥 식의 값은 람다의 인자로 전달된다.
    let의 반환값은 람다가 반환하는 값과 같다.
    외부 영역에 새로운 변수를 도입하는 일을 피하고 싶을 때 주로 이 함수를 사용한다.

     let은 지정된 값이 null이 아닌 경우에 코드를 싫행해야 한느 경우
     */
    Address(city = "London", street =  "Baker Street", house = "221b").let {
        //이 안에서는 it 파라미터를 통해 Address 인스턴스에 접근할 수 있음
        println("let(): To City : ${it.city}")
        it.post("Hello!")
    }

    /*
    [apply/also 함수]
    apply 함수는 확장 람다를 받는 확장 함수이며 자신의 수신 객체를 반환한다.
    이 함수는 일반적으로 runt()과 달리 반환값을 만들어내지 않고 객체의 상태를 설정하는 경우에 사용한다.
     */
    val message2 = readln() ?: return
    Address().apply {
        city = "London"
        street = "Baker Street"
        house = "221b"
    }.post(message2)

    val message3 = readln() ?: return
    Address().also {
        it.city = "London"
        it.street = "Baker Street"
        it.house = "221b"
    }.post(message3)

}