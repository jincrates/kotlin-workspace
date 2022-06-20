package me.jincrates.kopringmvc.controller.get

import me.jincrates.kopringmvc.model.http.UserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class GetApiController {

    //요즘 방식
    @GetMapping(path = ["/hello", "/abc"])  //GET http://localhost:8080/api/hello
    fun hello(): String {
        return "hello kopring"
    }

    //엣날 방식
    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("get-mapping/path-variable/{name}/{age}")  //GET http://localhost:8080/api/get-mapping/path-variable/jincrates
    fun pathVariable(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") _age : Int): String {
        val name = "kotlin"
        println("${_name}, ${_age}")
        return "$_name $_age"
    }

    // http://localhost:8080/api/page?key=value&key=value
    @GetMapping("/get-mapping/query-param")
    fun queryParam(
        @RequestParam(name = "name") name: String,
        @RequestParam(value = "age") age: Int
    ): String {
        println("${name}, ${age}")
        return "$name $age"
    }

    // name, age, address, email
    // 주소 url에는 하이픈(-)을 쓸 수 없음
    // phoneNumber => phonenumber, phone-number
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    // map을 사용하면 파라미터 name을 좀 더 유연하게 사용할 수 있다.
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map.get("phone-number")
        println(phoneNumber)
        return map
    }
}