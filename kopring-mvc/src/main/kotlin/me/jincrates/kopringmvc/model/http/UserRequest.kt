package me.jincrates.kopringmvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest(
    var name: String?=null,
    var age: Int?=null,
    var email: String?=null,
    var address: String?=null,

    //@JsonProperty("phone_number")
    var phoneNumber: String?= null //자바 네이밍은 카멜케이스, api는 주로 스네이크 표기
)
