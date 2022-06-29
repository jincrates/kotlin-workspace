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
@TestPropertySource(properties = ["spring.config.location=classpath:application.yml"])
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Test
    fun saveTest() {
        val member = Member().apply {
            this.name = "진크"
            this.email = "jincrates@email.com"
            this.password = "a12345!"
            this.joinDate = "2020-06-22 00:00:00"
            this.phoneNumber = "010-1111-2222"
            this.role = MemberRole.USER
            this.status = Status.ACTIVE
        }

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
}