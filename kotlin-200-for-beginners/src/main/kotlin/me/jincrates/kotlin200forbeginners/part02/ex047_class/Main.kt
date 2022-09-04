package me.jincrates.kotlin200forbeginners.part02.ex047_class;

/*
047. 클래스(Class)
자바에서 public 클래스를 선언하려면 클래스 이름이 파일 이름과 같아야 하고,
public 클래스는 파일 하나당 한 개만 존재할 수 있다.
클래스 이름이 파일 이름과 같아야 할 의무가 없으며,
한 파일 내에 여러 개의 public 클래스를 선언할 수도 있다.

클래스는 객체를 찌겅내기 위한 설계도이다.
클래스 안에 포함된 프로퍼티는, 이 클래스대로 객체를 만들면
객체 안에 이렇게 생긴 프로퍼티가 들어갈 것이라고 알려주기 위한 모형 변수이다.
그래서 클래스를 선언한다 해도 클래스 속의 프로퍼티가 곧바로 생성되지는 않는다.

클래스를 선언하면, 클래스 이름과 동일한 이름의 타입이 만들어진다.

클래스를 선언하면 클래스 이름과 동일한 특수 함수가 같이 선언된다.
Person 함수를 호출하면 Person 클래스의 내용대로 객체가 힙 영역에 만들어진다.
이 함수의 반환 타입은 Person이며, 값은 갓 생성된 객체의 참조값이다.

클래스로부터 생성된 객체는 특별히 인스턴스라고 부리기도 한다.
인스턴스(Instance)는 '구체적인 것'이라는 뜻을 갖고 있는데,
클래스라는 '틀'로부터 '구체적으로' 만들어지기 때문이다.

클래스 덕에 일일이 객체를 생성하는 부담은 줄었는데, 아쉬운 점이 하나 있다.
바로 프로퍼티에 값을 일일이 넣어야 한다는 점이다.
인스턴스를 생성하고 나면 어차피 프로퍼티에 값을 하나씩 저장해야 하므로
클래스를 선언한 의미가 생각보다 별로 없다. 이 문제는 '생성자'에서 다시 다루겠다.
 */
class Person {
    var name: String = ""
    var age: Int = 0
}

fun main(args:Array<String>): Unit {
    val person: Person
    person = Person()
    person.name = "홍길동"
    person.age = 29

    val person2 = Person()
    person2.name= "백쏨이"
    person2.age = 17

    val person3 = Person()
    person3.name = "John"
    person3.age = 52
}