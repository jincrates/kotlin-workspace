package me.jincrates.concurrencyproblems.facade

import me.jincrates.concurrencyproblems.service.LectureReservationService
import mu.KotlinLogging
import org.redisson.api.RedissonClient
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.concurrent.TimeUnit

@Service
class RedissonLockFacade(
    private val redissonClient: RedissonClient,
    private val lectureReservationService: LectureReservationService,
) {
    private val logger = KotlinLogging.logger {}

    fun addReservations(key: Long, count: Long) {
        val lock = redissonClient.getLock(key.toString())

        try {
            val available = lock.tryLock(5, 1, TimeUnit.SECONDS)

            //lock 획득 실패시
            if (!available) {
                logger.warn { "lock 획득을 실패했습니다." }
                return
            }

            lectureReservationService.addReservations(key, count)
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        } finally {
            lock.unlock()
        }
    }

}