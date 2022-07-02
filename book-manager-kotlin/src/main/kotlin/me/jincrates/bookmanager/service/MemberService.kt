package me.jincrates.bookmanager.service

import me.jincrates.bookmanager.domain.members.Member
import me.jincrates.bookmanager.domain.members.MemberRepository
import me.jincrates.bookmanager.web.http.dto.MemberDto
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    // C
    fun create(memberDto: MemberDto): MemberDto? {
        return memberDto.let {
            Member().toEntity(it)
        }.let{
            memberRepository.save(it)
        }.let {
            MemberDto().of(it)
        }
    }

    // R
    fun read(id: Long): MemberDto? {
        return memberRepository.findById(id).get().let {
            MemberDto().of(it)
        }
    }

    fun readAll(): MutableList<MemberDto> {
        return memberRepository.findAll().map {
            MemberDto().of(it)
        }.toMutableList()
    }

    // U
    fun update(memberDto: MemberDto): MemberDto? {
        return  Member().toEntity(memberDto).let {
            memberRepository.save(it)
        }.let {
            MemberDto().of(it)
        }
    }

    // D
    fun delete(id: Long): Boolean {
        memberRepository.deleteById(id)
        return !memberRepository.existsById(id)
    }
}