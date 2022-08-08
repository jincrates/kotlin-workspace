package me.jincrates.kopringmvc.example.advice

import me.jincrates.kopringmvc.example.controller.exception.ExceptionApiController
import me.jincrates.kopringmvc.example.controller.put.PutApiController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

//스프링에서 일어나는 모든 예외를 처리할 수 있다.
//basePackageClasses : 적용하려는 Controller를 지정할 수 있다.
//@RestControllerAdvice
@RestControllerAdvice(basePackageClasses = [PutApiController::class])
class GlobalControllerAdvice {

    @ExceptionHandler(value = [RuntimeException::class])
    fun exception(e: RuntimeException): String {
        return "Server Error"
    }

    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String> {  // 리턴 타입을 String으로 지정시 200 OK
        //예제를 위한 작성. 원래는 이런 에러는 사용자에게 알려주면 안된다.
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
    }
}