package me.jincrates.uservice.model

data class SignUpRequest(
    val email: String,
    val password: String,
    val username: String,
)