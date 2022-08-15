package me.jincrates.concurrencyproblems.service

import me.jincrates.concurrencyproblems.repository.LectureReservationRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
class OptimisticLockService(
    private val lectureReservationRepository: LectureReservationRepository,
) {

    /**
     * 예약자 추가(OptimisticLock)
     */
    @Transactional
    fun addReservations(id: Long, count: Long) {
        val lectureReservation = lectureReservationRepository.findByIdWithOptimisticLock(id) ?: throw RuntimeException("예약정보를 찾을 수 없습니다.")

        lectureReservation.addReservation(count)

        lectureReservationRepository.saveAndFlush(lectureReservation)
    }

}