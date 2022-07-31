package me.jincrates.bookmanager.exception

import com.auth0.jwt.exceptions.TokenExpiredException
import mu.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception

//전체 컨트롤러 예외사항을 감지
@RestControllerAdvice
class GlobalExceptionHandler {

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(ServerException::class)
    fun handleServerException(ex: ServerException) : ErrorResponse {
        logger.error { ex.message }  //에러 로깅
        return ErrorResponse(code = ex.code, message = ex.message)
    }

    //토큰 만료 exception을 분리한 이유: 기존 정의한 에러와는 전혀 다른 에러를 타기 때문
    @ExceptionHandler(TokenExpiredException::class)
    fun handleTokenExpiredException(ex: TokenExpiredException) : ErrorResponse {
        logger.error { ex.message }
        return ErrorResponse(code = 401, message = "Token Expired Error")
    }

    //ServerException에 정의되지 않은 Exception
    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception) : ErrorResponse {
        logger.error { ex.message }
        //보안취약점: 서버 오류가 클라이언트에게 노출되지 않도록 logger에서만 에러 내용을 확인하도록 한다.
        return ErrorResponse(code = 500, message = "Internal Server Error")
    }
}