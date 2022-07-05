package me.jincrates.bookmanager.web

import me.jincrates.bookmanager.service.LoanService
import me.jincrates.bookmanager.web.http.dto.LoanDto
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/api/loan")
@RestController
class LoanApiController(
    private val loanService: LoanService
) {

    @PostMapping(path = [""])
    fun loan(@Valid @RequestBody loanDto: LoanDto, bindingResult: BindingResult): Any? {

        // validate
        if (bindingResult.hasErrors()) {
            val messages = StringBuilder();
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                messages.append("${field.field} : $message\n")
            }
            return ResponseEntity.badRequest().body(messages.toString())
        }

        return loanService.loan(loanDto, loanDto.memberId)
    }

    @PostMapping("/{loanId}/return")
    fun returnBook(@PathVariable(name="loanId") _loanId: Long) {

    }

    @GetMapping(path = [""])
    fun readLoan(
        @RequestParam(required = false) id: Long?
    ) {

    }
}