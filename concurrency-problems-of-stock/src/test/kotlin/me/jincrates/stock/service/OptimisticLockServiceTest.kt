package me.jincrates.stock.service

import me.jincrates.stock.domain.Stock
import me.jincrates.stock.domain.StockRepository
import me.jincrates.stock.facade.OptimisticLockFacade
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import java.lang.RuntimeException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@SpringBootTest
class OptimisticLockServiceTest {

    @Autowired lateinit var optimisticLockFacade: OptimisticLockFacade
    @Autowired lateinit var stockRepository: StockRepository

    @BeforeEach
    fun before() {
        val stock = Stock(productId = 1L, quantity = 100L)
        stockRepository.saveAndFlush(stock)
    }

    @AfterEach
    fun after() = stockRepository.deleteAll()

    @Test
    @DisplayName("동시에 100개 요청")
    fun stock_decrease_concurrency() {
        val threadCount = 100

        //ExecutorService: 비동기 작업을 단순화하여 사용하도록 하는 java api
        val executorService: ExecutorService = Executors.newFixedThreadPool(32)

        //CountDownLatch: 다른 쓰레드에서 수행중인 작업이 완료될 때까지 대기하는 역할
        val latch = CountDownLatch(threadCount)

        for (i in 0..threadCount) {
            executorService.submit {
                try {
                    optimisticLockFacade.decrease(1L, 1L)
                } finally {
                    latch.countDown()
                }
            }
        }
        latch.await()

        //예상: 100 - (1 * 100) = 0
        val stock = stockRepository.findByIdOrNull(1L) ?: throw RuntimeException("재고를 찾을 수 없습니다.")
        assertEquals(0L, stock.quantity)
    }
}