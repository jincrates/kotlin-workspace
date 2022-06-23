package me.jincrates.kopringmvc.controller.page

import me.jincrates.kopringmvc.model.http.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PageController {

    // http://localhost:8080/main
    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }

    //@Controller를 사용하는 Controller에서 Json 형태의 데이터를 내려받아야할 때 사용
    @ResponseBody
    @GetMapping("/test")
    fun response(): UserRequest {
        return UserRequest().apply {
            this.name = "jincrates"
        }
    }
}