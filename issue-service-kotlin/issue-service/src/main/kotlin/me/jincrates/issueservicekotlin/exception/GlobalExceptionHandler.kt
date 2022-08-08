package me.jincrates.issueservicekotlin.exception

import com.auth0.jwt.exceptions.TokenExpiredException
import mu.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

//전체 컨트롤러 예외사항을 감지
@RestControllerAdvice
class GlobalExceptionHandler {

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(ServerException::class)
    fun handleServerException(ex: ServerException) : ErrorResponse {
        logger.error { ex.message }  //에러 로깅

        return ErrorResponse(code = ex.code, message = ex.message)
    }

    //토큰 만료 exception을 분리한 이유: 기존 정의한 에러와는 전혀 상관이 없기 때문
    @ExceptionHandler(TokenExpiredException::class)
    fun handleTokenExpiredException(ex: TokenExpiredException) : ErrorResponse {
        logger.error { ex.message }  //에러 로깅

        return ErrorResponse(code = 401, message = "Token Expired Error")
    }

    //ServerException에 정의되지 않은 Exception
    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception) : ErrorResponse {
        logger.error { ex.message }  //에러 로깅

        //보안취약점: 서버오류가 클라이언트에게 노출이 되면 되지 않기 때문에 logger에서만 디버깅을 통해서 확인하도록
        return ErrorResponse(code = 500, message = "Internal Server Error")
    }
}