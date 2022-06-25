package me.jincrates.kopringmvc.controller.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//테스트 예제로 인한 controller이지 이런건 존재하지 않는다.
@RestController
@RequestMapping("/api/exception")
class ExceptionApiController {

    @GetMapping("/hello")
    fun hello() {
        if (true) {
            //throw RuntimeException("강제 exception 발생")
            val list = mutableListOf<String>()
            val temp = list[0]
        }
    }

    //클래스 내부에 작성되면 해당 컨트롤러 안에서만 처리가 가능하다.
    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String> {  // 리턴 타입을 String으로 지정시 200 OK
        println("controller exception handler")
        //예제를 위한 작성. 원래는 이런 에러는 사용자에게 알려주면 안된다.
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
    }
}