package me.jincrates.kopringmvc.example.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import me.jincrates.kopringmvc.example.annotation.StringFormatDateTime
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern
import javax.validation.constraints.PositiveOrZero
import javax.validation.constraints.Size

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest(

    @field: NotEmpty
    @field: Size(min = 2, max = 10)
    var name: String?=null,

    @field: PositiveOrZero  // 0 < 숫자를 검증 0도 포함 (양수)
    var age: Int?=null,

    @field: Email  // email 양식
    var email: String?=null,

    @field: NotBlank  //공백 검증(null도 포함)
    var address: String?=null,

    //@JsonProperty("phone_number")
    @field: Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$", message = "010-0000-0000 형식으로 입력해야합니다")  // 들어오는 양식이 핸드폰 번호를 잘 지키는지 정규식 검증
    var phoneNumber: String?= null, //자바 네이밍은 카멜케이스, json에서는 주로 스네이크 표기

    @field: StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다")
    var createdAt: String?= null  //yyyy-MM-dd HH:mm:ss  ex) 2022-06-25 09:36:00
)