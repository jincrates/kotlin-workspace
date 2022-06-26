package me.jincrates.kopringmvc.todo.annotation

import me.jincrates.kopringmvc.example.validator.StringFormatDateTImeValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [StringFormatDateTImeValidator::class])
@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class StringFormatDateTime(
    val pattern: String = "yyyy-MM-dd HH:mm:ss",
    val message: String = "시간 형식이 유효하지 않습니다",
    //annotation default 설정이라서 넘어가도록 하자.
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)