package me.jincrates.issueservicekotlin.exception

data class ErrorResponse(
    val code: Int, // Http Status 코드로는 부족하여 커스텀 코드작성
    val message: String,
)
