package me.jincrates.stock.service

import me.jincrates.stock.domain.Stock
import me.jincrates.stock.domain.StockRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import java.lang.RuntimeException

@SpringBootTest
class StockServiceTest {

    @Autowired lateinit var stockService : StockService
    @Autowired lateinit var stockRepository: StockRepository

    @BeforeEach
    fun before() {
        val stock = Stock(productId = 1L, quantity = 100L)
        stockRepository.saveAndFlush(stock)
    }

    @AfterEach
    fun after() = stockRepository.deleteAll()

    @Test
    @DisplayName("재고 감소 테스트")
    fun stockDecreaseTest() {
        val stockId = 1L
        stockService.decrease(stockId, 1L)

        //예상: 100 - 1 = 99
        val stock = stockRepository.findByIdOrNull(stockId) ?: throw RuntimeException("재고를 찾을 수 없습니다. stock.id = $stockId")
        assertEquals(99, stock.quantity)
    }

}