package me.jincrates.stock.service

import me.jincrates.stock.domain.StockRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
class PessimisticLockService(
    private val stockRepository: StockRepository,
) {
    /**
     * 재고 감소(PessimisticLock)
     */
    @Transactional
    fun decrease(id: Long, quantity: Long) {
        val stock = stockRepository.findByIdWithPessimisticLock(id) ?: throw RuntimeException("재고를 찾을 수 없습니다. stock.id = $id")

        stock.decrease(quantity)

        stockRepository.saveAndFlush(stock)
    }
}