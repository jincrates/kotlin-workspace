package me.jincrates.kotlin200forbeginners.part01;

/*
009. 실수 타입의 함정
정수 값만을 다룬다면 무조건 정수 타입을 사용하는 편이 좋다.
실수 타입에는 치명적인 문제점이 있기 때문이다.

실수 값은 2진수 유효숫자로 표현되기 때문에 상황에 따라 정확한 값을 가리킬 수 없다.
예컨대 10진수로 0.1이라는 값은, 2진수로 표현할 때 소수점이 정확하게 나눠 떨어지지 않는 무한 소수가 되기 때문에
표현할 수 있는 범위에서 가장 근사한 값인 0.10000000149011612로 바뀌어 저장된다.

3번의 덧셈에서는 오차가 무시할 수 있을정도로 작아 올바른 결과가 나왔지만,
10번의 덧셈은 오차가 무시할 수 없을 정도로 누적되어 잘못된 결과가 출력되었다.

항상 정확한 결과만을 산출해야 하는 컴퓨터에 이런 특성은 너무 치명적이다.
실수 계산을 할 때는 항상 대략적인 값만 얻을 수 있다는 것을 염두에 두고,
꼭 실수 값을 처리해야 하는 상황이 아니라면 정수 타입만을 사용하자.
 */
fun main(args:Array<String>): Unit {
    //println(0.1f.toDouble())
    println(0.1f)
    println(0.1f + 0.1f + 0.1f)
    //0.1을 10번 더했는데 왜 1.0000001이 나오지?
    println(0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f)
    println(0.1f * 10)
}