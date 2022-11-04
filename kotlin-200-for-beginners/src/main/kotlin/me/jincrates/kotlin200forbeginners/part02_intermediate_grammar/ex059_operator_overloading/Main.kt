package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex059_operator_overloading;

/*
059. 연산자 오버로딩(Operator Overloading)
operator의 의미는 Point의 인스턴스 간에 연산자를 사용했을 떄 이 멤버 함수를 대신 호출해달라는 뜻이다.
함수 이름은 plus로 했는데, 이 이름은 정해진 이름이며, 다른 이름을 사용하면 연산자 오버로딩이 제대로 되지 않는다.
plus라는 이름은 + 연산자를 오버로딩한다. 즉 pt1 + pt2를 하면, 실제로 pt1.plus(pt2)를 수행한다.
 */
fun main(args:Array<String>): Unit {

    val pt1 = Point(3, 7)
    val pt2 = Point(2, -6)

    val pt3 = pt1 + pt2
    val pt4 = pt3 * 6
    val pt5 = pt4 / 3

    pt3.print()
    pt4.print()
    pt5.print()
}