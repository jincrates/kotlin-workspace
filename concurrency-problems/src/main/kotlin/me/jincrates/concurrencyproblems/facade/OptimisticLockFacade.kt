package me.jincrates.concurrencyproblems.facade

import me.jincrates.concurrencyproblems.service.OptimisticLockService
import org.springframework.stereotype.Service

@Service
class OptimisticLockFacade(
    private val optimisticLockService: OptimisticLockService,
) {

    //실패시 재시도를 하도록 설정합니다.
    fun addReservations(id: Long, count: Long) {
        while(true) {
            try {
                optimisticLockService.addReservations(id, count)
                break
            } catch (e: Exception) {
                Thread.sleep(50)
            }
        }
    }
}