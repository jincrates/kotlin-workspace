package me.jincrates.stock.facade

import me.jincrates.stock.service.OptimisticLockService
import org.springframework.stereotype.Service
import java.lang.Exception
import java.lang.RuntimeException

@Service
class OptimisticLockFacade(
    private val optimisticLockService: OptimisticLockService,
) {

    fun decrease(id: Long, quantity: Long) {
        //실패시 재시도를 하도록
        while(true) {
            try {
                optimisticLockService.decrease(id, quantity)
                break
            } catch (e: Exception) {
                Thread.sleep(50)
            }
        }
    }
}