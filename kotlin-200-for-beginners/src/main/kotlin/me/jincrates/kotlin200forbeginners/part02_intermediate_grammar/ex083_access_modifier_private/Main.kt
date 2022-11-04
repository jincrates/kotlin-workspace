package me.jincrates.kotlin200forbeginners.part02_intermediate_grammar.ex083_access_modifier_private;

/*
000. 제목()

 */
fun main(args:Array<String>): Unit {
   //num = 5 //에러
    hello(15)

    val person = Person(10)
    println(person.age)
    //person.age = 20 //에러

    println(person.isYoung)
}