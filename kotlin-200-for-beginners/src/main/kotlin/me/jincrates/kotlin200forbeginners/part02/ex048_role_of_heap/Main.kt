package me.jincrates.kotlin200forbeginners.part02.ex048_role_of_heap;

/*
048. 힙 영역의 존재 이유
객체는 왜 스택이 아닌 힙 영역에 생성될까? 굳이 스택 영역과 힙 영역을 나눠놓은 이유가 무엇일까?

apple 참조 변수는 createProduct 함수가 끝났으므로 스택에서 지워진다.
하지만, apple 참조 변수가 가리키고 있던 객체는 힙에서 지워지지 않는다.

만약, 힙이라는 공간이 없었다면 main 함수의 product 변수와 printProductInfo() 함수의
product 매개변수가 각각 자신만의 name과 price 변수를 가지고 있었을 것이다.
이처럼 힙 영역을 두면, 하나의 객체를 여러 참조 변수에서 공유하는 형태로 사용할 수 있어 훨씬 메모리 공간을 절약할 수 있다.
 */
fun main(args:Array<String>): Unit {
    val product: Product = createProduct()
    printProductInfo(product)
    processProduct(product)
    printProductInfo(product)
}

fun createProduct(): Product {
    val apple = Product()
    apple.name = "Apple"
    apple.price = 1000

    return apple
}

fun processProduct(product: Product) {
    product.price += 500
}

fun printProductInfo(product: Product) {
    println("이름: ${product.name}")
    println("가격: ${product.price}")
}
