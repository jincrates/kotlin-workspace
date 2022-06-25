package me.jincrates.kopringmvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
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

    //createdAt에 대한 유효성 검증은 isValidCreatedAd() "메소드"를 통해 검증하기 떄문에 @field를 붙이지 않는다.
   var createdAt: String?= null  //yyyy-MM-dd HH:mm:ss  ex) 2022-06-25 09:36:00
) {

    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 여야 합니다.")
    private fun isValidCreatedAd(): Boolean {  // 정상: true, 비정상: false
        return try {
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        } catch (e: Exception) {
            false
        }
    }

}
