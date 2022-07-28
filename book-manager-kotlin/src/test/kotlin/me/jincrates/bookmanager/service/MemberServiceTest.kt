package me.jincrates.bookmanager.service

import me.jincrates.bookmanager.common.Status
import me.jincrates.bookmanager.domain.members.Member
import me.jincrates.bookmanager.domain.members.MemberRole
import me.jincrates.bookmanager.web.http.dto.MemberDto
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@TestPropertySource(properties = ["spring.config.location=classpath:application-test.yml"])
@SpringBootTest
class MemberServiceTest {

    @Autowired
    lateinit var memberService: MemberService

    fun createMember(): Member {
        val member = MemberDto().apply {
            this.name = "진크"
            this.email = "jincrates@email.com"
            this.password = "a12345!"
            this.joinDate = "2020-06-22 00:00:00"
            this.phoneNumber = "010-1111-2222"
            this.role = MemberRole.USER
            this.status = Status.ACTIVE
        }

        return Member().createMember(member)
    }

    @Test
    @DisplayName("회원가입 테스트")
    fun createMemberTest() {
        val member = MemberDto().of(createMember())
        val savedMember = memberService.create(member)

        assertNotNull(savedMember)
        assertEquals(member.name, savedMember?.name)
        assertEquals(member.email, savedMember?.email)
        assertEquals(member.joinDate, savedMember?.joinDate)
        assertEquals(member.phoneNumber, savedMember?.phoneNumber)
        assertEquals(member.role, savedMember?.role)
        assertEquals(member.status, savedMember?.status)
    }

    @Test
    fun
}