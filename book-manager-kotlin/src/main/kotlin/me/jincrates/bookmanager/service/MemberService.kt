package me.jincrates.bookmanager.service

import me.jincrates.bookmanager.domain.members.MemberRepository
import me.jincrates.bookmanager.domain.members.toEntity
import me.jincrates.bookmanager.web.http.MemberDto
import me.jincrates.bookmanager.web.http.toDto
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
class MemberService(
    private var memberRepository: MemberRepository
) {

    // C
    fun create(memberDto: MemberDto): MemberDto? {
        return memberDto.let {
            toEntity(it)
        }.let {
            memberRepository.save(it)
        }.let {
            MemberDto().toDto(it)
        }
    }

    // R

    // U

    // D
}