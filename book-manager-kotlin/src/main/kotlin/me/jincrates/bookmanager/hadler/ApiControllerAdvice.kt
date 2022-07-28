package me.jincrates.bookmanager.hadler

import me.jincrates.bookmanager.service.MemberService
import me.jincrates.bookmanager.web.BookApiController
import me.jincrates.bookmanager.web.LoanApiController
import me.jincrates.bookmanager.web.MemberApiController
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest
import me.jincrates.bookmanager.web.http.Error
import me.jincrates.bookmanager.web.http.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import java.time.LocalDateTime
import javax.validation.ConstraintViolationException

@ControllerAdvice(
    basePackageClasses = [
        BookApiController::class,
        MemberApiController::class,
        LoanApiController::class
    ]
)
class ApiControllerAdvice {

    @ExceptionHandler(value = [RuntimeException::class])
    fun exception(e: RuntimeException): String {
        return "Server Error : " + e.message
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(e: MethodArgumentNotValidException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        val message = "요청에 에러가 발생하였습니다."
        val errorResponse = makeErrorResponse(e, request, message)

        return ResponseEntity.badRequest().body(errorResponse)
    }


    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun constraintViolationException(e: ConstraintViolationException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        val errors = mutableListOf<Error>()

        e.constraintViolations.forEach {
            val error = Error().apply {
                this.field = it.propertyPath.last().name //propertyPath 마지막이 필드명이기 때문
                this.message = it.message
                this.value = it.invalidValue
            }
            errors.add(error)
        }

        val errorResponse = ErrorResponse().apply {
            this.resultCode = "FAIL"
            this.httpStatus = HttpStatus.BAD_REQUEST.value().toString()
            this.httpMethod = request.method
            this.message = "요청에 에러가 발생하였습니다."
            this.path = request.requestURI.toString()
            this.timestamp = LocalDateTime.now()
            this.errors = errors
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }

    private fun makeErrorResponse(
        e: MethodArgumentNotValidException,
        request: HttpServletRequest,
        errorMessage: String
    ): ErrorResponse {
        //1. 에러 분석
        val errors = mutableListOf<Error>()

        e.bindingResult.allErrors.forEach {
            Error().apply {
                this.field = (it as FieldError).field
                this.message = it.defaultMessage
                this.value = it.rejectedValue
            }.apply {
                errors.add(this)
            }
        } // for each end

        // 2. ErrorResponse
        val errorResponse = ErrorResponse().apply {
            this.resultCode = "FAIL"
            this.httpStatus = HttpStatus.BAD_REQUEST.value().toString()
            this.httpMethod = request.method
            this.message = errorMessage
            this.path = request.requestURI
            this.timestamp = LocalDateTime.now()
            this.errors = errors
        }

        return errorResponse
    }
}
