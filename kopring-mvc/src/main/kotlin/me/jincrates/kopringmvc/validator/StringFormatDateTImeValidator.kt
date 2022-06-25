package me.jincrates.kopringmvc.validator

import me.jincrates.kopringmvc.annotation.StringFormatDateTime
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class StringFormatDateTImeValidator: ConstraintValidator<StringFormatDateTime, String> {

    private var pattern: String ?= null

    override fun initialize(constraintAnnotation: StringFormatDateTime?) {
        //어노테이션에서 가져온 패턴을 넣어준다.
        this.pattern = constraintAnnotation?.pattern
    }

    // 정상이면 true, 비정상이면 false
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return try {
            LocalDateTime.parse(value, DateTimeFormatter.ofPattern(this.pattern))
            true
        } catch (e: Exception) {
            false
        }
    }
}