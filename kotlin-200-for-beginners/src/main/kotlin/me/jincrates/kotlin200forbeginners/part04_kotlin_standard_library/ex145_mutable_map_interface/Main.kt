package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex145_mutable_map_interface;

/*
145. MutableMap 인터페이스 살펴보기
 */
fun main(args:Array<String>): Unit {

    val map: MutableMap<String, String> = mutableMapOf()
    println(map)

    println(map.put("Hi", "こんにちは"))
    println(map)

    println(map.put("Hi", "你好"))
    println(map)

    map["Hi"] = "안녕"
    println(map)

    map.putAll(mapOf("How is it going?" to "잘 지내?", "Bye!" to "잘 가!"))
    println(map)

    println(map.remove("Hi"))
    println(map)

    println(map.remove("Bye!", "잘"))
    println(map)

    println(map.remove("Bye!", "잘 가!"))
    println(map)

    map.clear()
    println(map)
}