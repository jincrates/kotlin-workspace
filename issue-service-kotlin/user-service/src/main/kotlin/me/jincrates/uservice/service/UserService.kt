package me.jincrates.uservice.service

import me.jincrates.uservice.domain.entity.User
import me.jincrates.uservice.domain.repository.UserRepository
import me.jincrates.uservice.exception.UserExistsException
import me.jincrates.uservice.model.SignUpRequest
import me.jincrates.uservice.utils.BCryptUtils
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {

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
}