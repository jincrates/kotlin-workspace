package me.jincrates.bookmanager.web.http

import com.fasterxml.jackson.annotation.JsonProperty
import me.jincrates.bookmanager.common.Status
import me.jincrates.bookmanager.common.annotation.StringFormatDateTime
import me.jincrates.bookmanager.domain.members.Member
import me.jincrates.bookmanager.domain.members.MemberRole
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

class MemberDto(

    var id: Long?= null,

    @field: NotBlank(message = "이름을 입력하지 않았습니다.")
    @field: Size(min = 2, message = "이름은 2글자 이상이어야 합니다.")
    var name: String?= null,

    @field: NotBlank(message = "이메일을 입력하지 않았습니다.")
    @field: Email
    var email: String?= null,

    @field: NotBlank(message = "비밀번호 입력하지 않았습니다.")
    @field: Size(min = 4, message = "비밀번호는 4자리 이상이어야 합니다.")
    var password: String?= null,

    @JsonProperty("join_date")
    @field: NotBlank(message = "입사일자를 입력하지 않았습니다.")
    @field: StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
    var joinDate: String?= null,

    @JsonProperty("phone_number")
    @field: Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$", message = "010-0000-0000 형식으로 입력해야합니다.")  // 들어오는 양식이 핸드폰 번호를 잘 지키는지 정규식 검증
    var phoneNumber: String?= null,

    @field: Enumerated(EnumType.STRING)
    var role: MemberRole?= null,

    @field: Enumerated(EnumType.STRING)
    var status: Status?= null

)

fun MemberDto.toDto(entity: Member): MemberDto {
    return MemberDto().apply {
        this.id = entity.id
        this.name = entity.name
        this.email = entity.email
        this.password = entity.password
        this.joinDate = entity.joinDate
        this.phoneNumber = entity.phoneNumber
        this.role = entity.role
        this.status = entity.status
    }
}

