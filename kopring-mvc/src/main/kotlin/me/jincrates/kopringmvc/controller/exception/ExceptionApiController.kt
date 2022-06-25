package me.jincrates.kopringmvc.controller.exception

import me.jincrates.kopringmvc.model.http.ErrorResponse
import me.jincrates.kopringmvc.model.http.Error
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest
import javax.validation.ConstraintViolationException
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

//테스트 예제로 인한 controller이지 이런건 존재하지 않는다.
@RestController
@RequestMapping("/api/exception")
@Validated
class ExceptionApiController {

    @GetMapping("/hello")
    fun hello() {
        if (true) {
            //throw RuntimeException("강제 exception 발생")
            val list = mutableListOf<String>()
            val temp = list[0]
        }
    }

    @GetMapping("")
    fun get(
        @NotBlank
        @Size(min = 2, max = 10)
        @RequestParam name: String,

        @Min(10)
        @RequestParam age: Int
    ): String {
        println("$name $age")
        return "$name $age"
    }

    // path(requestURI)를 가져오기 위해  request: HttpServletRequest 변수 추가
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun constraintViolationException(e: ConstraintViolationException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {

        // 1. 에러 분석
        val errors = mutableListOf<Error>()

        e.constraintViolations.forEach {
            val error = Error().apply {
                this.field = it.propertyPath.last().name //propertyPath 마지막이 필드명이기 때문
                this.message = it.message
                this.value = it.invalidValue
            }
            errors.add(error)
        }

        // 2. ErrorResponse
        val errorResponse = ErrorResponse().apply {
            this.resultCode = "FAIL"
            this.httpStatus = HttpStatus.BAD_REQUEST.value().toString()
            this.httpMethod = request.method
            this.message = "요청에 에러가 발생하였습니다."
            this.path = request.requestURI.toString()
            this.timestamp = LocalDateTime.now()
            this.errors = errors
        }
        // 3. ResponseEntity
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }

    //클래스 내부에 작성되면 해당 컨트롤러 안에서만 처리가 가능하다.
    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String> {  // 리턴 타입을 String으로 지정시 200 OK
        println("controller exception handler")
        //예제를 위한 작성. 원래는 이런 에러는 사용자에게 알려주면 안된다.
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
    }
}