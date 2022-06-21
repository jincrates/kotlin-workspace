package me.jincrates.kopringmvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class UserResponse(
    var result: Result ?= null,
    var description: String ?= null,
    var user: MutableList<UserRequest> ?= null
)

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class Result(
    var resultCode: String ?= null,    //result_code
    var resultMessage: String ?= null  //result_message
)

/*
{
    "result" : {
        "result_code" : "OK",
        "result_message" : "성공"
    },
    "description" : "~~~~~~",
    "user" : [
        {
            "name" : "jincrates",
            "age" : "10",
            "email" : "",
            "phoneNumber" : ""
        },
        {
            "name" : "platon",
            "age" : "20",
            "email" : "",
            "phoneNumber" : ""
        },
        {
            "name" : "kant",
            "age" : "30",
            "email" : "",
            "phoneNumber" : ""
        },
    ]


}
*/