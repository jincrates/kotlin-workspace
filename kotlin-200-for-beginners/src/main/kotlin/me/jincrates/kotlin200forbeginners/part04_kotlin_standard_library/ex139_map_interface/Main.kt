package me.jincrates.kotlin200forbeginners.part04_kotlin_standard_library.ex139_map_interface;

/*
139. Map 인터페이스 살펴보기
- keys: Map의 키들만 갖는 프로퍼티이다. Map의 키는 중복되지 않기 때문에 Set 타입으로 되어있다.
- values: Map의 값들만 갖는 프로퍼티이다. Map의 값은 중복되지 않기 때문에 Collection 타입으로 되어 있다.
- get: key에 해당하는 값을 반환하는 연산자 멤버 함수이다. 만약 key에 해당하는 값이 없으면 null이 반환된다. 그래서 반환 타입 V?이다.
- getOrDefault: key에 해당하는 값을 반환하되, key에 해당하는 값이 없으면 defaultValue를 대신 반환하다.
 */
fun main(args:Array<String>): Unit {

    val map: Map<String, String> = mapOf("Apple" to "사과", "Banana" to "바나나")

    println(map.size)
    println(map.keys)
    println(map.values)
    println(map.entries)
    println(map.isEmpty())
    println(map.containsKey("Cocoa"))
    println(map.containsValue("바나나"))
    println(map["Apple"])
    println(map.getOrDefault("Cocoa", "코코아"))
}