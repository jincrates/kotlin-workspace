package me.jincrates.bookmanager.domain.members

import me.jincrates.bookmanager.common.Status
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@TestPropertySource(properties = ["spring.config.location=classpath:application-test.yml"])
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    lateinit var memberRepository: MemberRepository

    fun createMember(): Member {
        return Member().apply {
            this.name = "진크"
            this.email = "jincrates@email.com"
            this.password = "a12345!"
            this.joinDate = "2020-06-22 00:00:00"
            this.phoneNumber = "010-1111-2222"
            this.role = MemberRole.USER
            this.status = Status.ACTIVE
        }
    }

    @Test
    fun saveTest() {
        val member = createMember()
        val result = memberRepository.save(member)
        println(result)

        assertNotNull(result)
        assertEquals("진크", result.name)
        assertEquals("jincrates@email.com", result.email)
        assertEquals("a12345!", result.password)
        assertEquals("2020-06-22 00:00:00", result.joinDate)
        assertEquals("010-1111-2222", result.phoneNumber)
        assertEquals(MemberRole.USER, result.role)
        assertEquals(Status.ACTIVE, result.status)
    }

    @Test
    fun validateDuplicateMemberTest() {
        //val member1 = createMember()
        val result = memberRepository.findByEmail("jincrates@email.com")
        println(result)
    }


    @Test
    fun updateTest() {
        val member = createMember();
        val insertMember = memberRepository.save(member)

        val updateMember = Member().apply {
            this.id = insertMember.id
            this.name = "진크라테스"
            this.email = insertMember.email
            this.password = insertMember.password
            this.joinDate = insertMember.joinDate
            this.phoneNumber = "010-3333-4444"
            this.role = MemberRole.ADMIN
            this.status = Status.INACTIVE
        }

        val result = memberRepository.save(updateMember)
        println(result)

        assertNotNull(result)
        assertEquals(insertMember.id, result.id)
        assertEquals("진크라테스", result.name)
        assertEquals(MemberRole.ADMIN, result.role)
        assertEquals(Status.INACTIVE, result.status)
    }
}