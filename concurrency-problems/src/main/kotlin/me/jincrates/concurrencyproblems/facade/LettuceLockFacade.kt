package me.jincrates.concurrencyproblems.facade

import me.jincrates.concurrencyproblems.repository.RedisLockRepository
import me.jincrates.concurrencyproblems.service.LectureReservationService
import org.springframework.stereotype.Service

@Service
class LettuceLockFacade (
    private val redisLockRepository: RedisLockRepository,
    private val lectureReservationService: LectureReservationService,
) {

    /**
     * 예약자 추가(Redis Lettuce Lock 사용하기)
     */
    fun addReservations(key: Long, count: Long) {
        //lock 획득 시도 - 레디스 부하걸리지 않도록 sleep(100)
        while(!redisLockRepository.lock(key)!!) {
            Thread.sleep(100)
        }

        //lock 획득 성공시
        try {
            lectureReservationService.addReservations(key, count)
        } finally {
            redisLockRepository.unlock(key)
        }
    }
}