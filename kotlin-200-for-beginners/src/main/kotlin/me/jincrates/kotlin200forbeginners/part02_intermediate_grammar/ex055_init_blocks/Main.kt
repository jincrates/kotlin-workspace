package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex055_init_blocks;

/*
055. init 블록 나누어 쓰기
init 블록은 여러 개로 나누어 쓸 수 있다.

인스턴스가 생성된다고 해서 init 블록이 곧장 실행되는 것은 아니다.
인스턴스가 생성되면, 위에서부터 순서대로 프로퍼티의 선언 및 초기화문과, init 블록이 실행된다.
Size 클래스 안에는 맨 꼭대기에 val width = width가 있으므로, 이 부분이 가장 먼저 실행된다.

보다시피 생성자의 매개변수는 init 블록뿐만 아니라 프로퍼티를 선언과 동시에 초기화는 데에도 사용할 수 있다.
 */
class Size(width: Int, height: Int) {
    val width = width
    val height: Int

    init {
        this.height = height
    }

    val area: Int

    init {
        area = width * height
    }
}

fun main(args:Array<String>): Unit {
    val size = Size(10, 50)
    println(size.area)
}