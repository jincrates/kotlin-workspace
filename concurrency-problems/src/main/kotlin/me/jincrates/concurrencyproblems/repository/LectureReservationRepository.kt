package me.jincrates.concurrencyproblems.repository

import me.jincrates.concurrencyproblems.domain.LectureReservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional
import javax.persistence.LockModeType

@Transactional(readOnly = true)
interface LectureReservationRepository : JpaRepository<LectureReservation, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select ls from LectureReservation ls where ls.id = :id")
    fun findByIdWithPessimisticLock(id: Long): LectureReservation?

    @Lock(LockModeType.OPTIMISTIC)
    @Query("select ls from LectureReservation ls where ls.id = :id")
    fun findByIdWithOptimisticLock(id: Long): LectureReservation?

}