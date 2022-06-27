package me.jincrates.bookmanager.domain

import lombok.Getter
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@Getter
@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
open class BaseEntity : BaseTimeEntity() {

    @CreatedBy
    @Column(updatable = false)
    lateinit var createdBy: String

    @LastModifiedBy
    lateinit var updatedBy: String
}