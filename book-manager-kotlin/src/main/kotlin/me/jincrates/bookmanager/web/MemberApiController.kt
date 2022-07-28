package me.jincrates.bookmanager.web

import me.jincrates.bookmanager.service.MemberService
import me.jincrates.bookmanager.web.http.dto.MemberDto
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/member")
class MemberApiController(
    private val memberService: MemberService
) {

    // R
    @GetMapping(path = [""])
    fun read(
        @RequestParam(required = false) id: Long?
    ): ResponseEntity<Any?> {
        return id?.let {
            memberService.read(it)
        }?.let {
            return ResponseEntity.ok(it)
        }?: kotlin.run {
            return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .header(HttpHeaders.LOCATION, "/api/member/all")
                .build()
        }
    }

    @GetMapping(path = ["/all"])
    fun readAll(): MutableList<MemberDto> {
        return memberService.readAll()
    }

    // C
    @PostMapping(path = [""])
    fun create(@Valid @RequestBody memberDto: MemberDto): MemberDto? {

        return memberService.create(memberDto)
    }

    // U
    @PutMapping(path = [""])
    fun update(@Valid @RequestBody memberDto: MemberDto): MemberDto? {
        return memberService.create(memberDto)
    }

    // D
    @DeleteMapping(path = ["/{id}"])
    fun delete(@PathVariable(name = "id") _id: Long): ResponseEntity<Any> {

        if (!memberService.delete(_id)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR). build()
        }

        return ResponseEntity.ok().build()
    }

}