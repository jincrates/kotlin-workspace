package me.jincrates.kotlin200forbeginners.part03.ex101_data_class;

/*
101. 데이터 클래스(Data Class)
클래스에는 크게 데이터 자체의 역할만 하는 클래스와, 데이터를 다루는 역할을 하는 클래스가 있다.
코틀린은 데이터에 특화된 클래스를 선언할 수 있는 문법을 제공한다.

클래스를 데이터 클래스로 선언하면, 뭐가 좋을까?
- Any 클래스에 들어 있는 equals, hashCode, toString 멤버 함수가 자동으로 오버라이딩된다.
- equals 멤버 함수는 각 프로퍼티의 값이 서로 모두 같으면 true, 하나라도 다르면 false를 반환하게 오버라이딩된다.
- toString 멤버 함수는 "Employee(name=..., age=..., salary-...)" 형태로 문자열을 반환하도록 오버라딩된다.
- 객체를 복사하는 copy 함수가 자동으로 선언된다.

copy 멤버 함수는 각 프로퍼티의 값을 그대로 복사한 새 인스턴스를 반환한다.

copy 멤버 함수를 똑같이 만들면?
copy와 똑같은 멤버 함수를 데이터 클래스에서 선언하면 충돌 오류가 발생한다.
단, euquals, hashCode, toString 멤버 함수는 선언해도 괜찮다.
이들을 직접 선언하면 직접 선언한 멤버 함수로 오버라이딩 된다.

데이터 클래스는 여러 가지 편의 기능을 제공하지만, 그만큼 제약사항이 많다.
클래스를 데이터 클래스로 선언하기 위해서는 다음의 규칙들을 지켜야 한다.
- 적어도 하나의 프로퍼티를 가져야 한다.
- 생성자 매개변수에는 반드시 var이나 val을 같이 써야 한다. 즉, 프로퍼티에 대응하지 않는 생성자 매개변수를 가질 수 없다.
- abstract, open, sealed, inner 키워드를 붙일 수 없다.
- 인터페이스로만 구현할 수 있다. 단, 코틀린 1.1 버전부터는 sealed 클래스도 상속 가능하다.
- component1, component2, ...와 같은 이름으로 멤버 함수를 선언할 수 없다. 컴파일러가 내부적으로 사용하는 이름이기 때문이다.
 */
data class Employee(val name: String, val age: Int, val salary: Int)

fun main(args:Array<String>): Unit {
    val first = Employee("John", 30, 3000)
    val second = Employee("Page", 24, 5300)
    val third = first.copy()

    println(first.toString())
    println(third.toString())
    println(first == second)
    println(first == third)
}