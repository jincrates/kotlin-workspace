package me.jincrates.stock.facade

import me.jincrates.stock.domain.RedisLockRepository
import me.jincrates.stock.service.StockService
import org.springframework.stereotype.Service

@Service
class LettuceLockStockFacade(
    private val redisLockRepository: RedisLockRepository,
    private val stockService: StockService,
) {

    fun decrease(key: Long, quantity: Long) {
        while (!redisLockRepository.lock(key)!!) {
            Thread.sleep(100)
        }

        //lock 획득 성공시
        try {
            stockService.decrease(key, quantity)
        } finally {
            redisLockRepository.unlock(key)
        }
    }

}