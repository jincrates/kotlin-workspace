package me.jincrates.kopringmvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class ErrorResponse(

    @field: JsonProperty("result_code")
    var resultCode: String ?= null,

    @field: JsonProperty("http_status")
    var httpStatus: String ?= null,

    @field: JsonProperty("http_method")
    var httpMethod: String ?= null,

    var message: String ?= null,
    var path: String ?= null,
    var timestamp: LocalDateTime ?= null,
    var errors: MutableList<Error> ?= mutableListOf()
)

data class  Error(
    var field: String ?= null,
    var message: String ?= null,
    var value: Any ?= null
)


/*
{
    "result_code" : "FAIL",
    "http_code" : "400",
    "http_method": "GET"
    "message" : "요청이 잘못 되었습니다.",
    "path" : "/api/exception/hello",
    "timestamp" : "2022-06-25T10:41:00",
    "errors": [
        {
            "field" : "_name",
            "message" : "5글자 이상이여야 합니다."
            "value" : 2
        }
    ]

}
*/