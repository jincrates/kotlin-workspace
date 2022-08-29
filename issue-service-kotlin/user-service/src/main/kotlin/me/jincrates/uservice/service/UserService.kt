package me.jincrates.uservice.service

import me.jincrates.uservice.config.JWTProperties
import me.jincrates.uservice.domain.entity.User
import me.jincrates.uservice.domain.repository.UserRepository
import me.jincrates.uservice.exception.PasswordNotMatchedException
import me.jincrates.uservice.exception.UserExistsException
import me.jincrates.uservice.exception.UserNotFoundException
import me.jincrates.uservice.model.SignInRequest
import me.jincrates.uservice.model.SignInResponse
import me.jincrates.uservice.model.SignUpRequest
import me.jincrates.uservice.utils.BCryptUtils
import me.jincrates.uservice.utils.JWTClaim
import me.jincrates.uservice.utils.JwtUtils
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class UserService(
    private val userRepository: UserRepository,
    private val jwtProperties: JWTProperties,
    private val cacheManager: CoroutineCacheManager<User>,
) {
    companion object {
        private val CACHE_TTL = Duration.ofMinutes(1)
    }

    suspend fun signUp(signUpRequest: SignUpRequest) {
        with(signUpRequest) {
            userRepository.findByEmail(email)?.let {
                throw UserExistsException()
            }
            val user = User(
                email = email,
                password = BCryptUtils.hash(password),
                username = username
            )
            userRepository.save(user)
        }
    }

    suspend fun signIn(signInRequest: SignInRequest): SignInResponse {
        return with(userRepository.findByEmail(signInRequest.email) ?: throw  UserNotFoundException()) {
            val verified = BCryptUtils.verify(signInRequest.password, password)
            if (!verified) {
                throw PasswordNotMatchedException()
            }

            //로그인 처리
            val jwtClaim = JWTClaim(
                userId = id!!,
                email = email,
                profileUrl = profileUrl,
                username = username,
            )

            val token = JwtUtils.createToken(jwtClaim, jwtProperties)

            //캐싱 처리
            cacheManager.awaitPut(key = token, value = this, ttl = CACHE_TTL)

            SignInResponse(
                email = email,
                username = username,
                token = token
            )
        }
    }
}