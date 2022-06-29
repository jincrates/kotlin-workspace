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
        return toEntity(memberDto).let {
            memberRepository.save(it)
        }.let {
            MemberDto().toDto(it)
        }
    }

    // R
    fun read(id: Long): MemberDto? {
        return memberRepository.findById(id).get().let {
            MemberDto().toDto(it)
        }
    }

    fun readAll(): MutableList<MemberDto> {
        return memberRepository.findAll().map {
            MemberDto().toDto(it)
        }.toMutableList()
    }

    // U
    fun update(memberDto: MemberDto): MemberDto? {
        return toEntity(memberDto).let {
            memberRepository.save(it)
        }.let {
            MemberDto().toDto(it)
        }
    }

    // D
    fun delete(id: Long): Boolean {
        memberRepository.deleteById(id)
        return !memberRepository.existsById(id)
    }
}