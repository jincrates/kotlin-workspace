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
class Address {
    var zipCode: Int = 0
    var city: String = ""
    var street: String = ""
    var house: String = ""

    fun post(message: String): Boolean {
        "Message for {$zipCode, $city, $street, $house}: $message"
        return readln() == "OK"
    }
}

fun main() {

}