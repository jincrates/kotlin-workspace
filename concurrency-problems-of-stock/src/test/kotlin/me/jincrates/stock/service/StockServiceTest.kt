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
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

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
    fun stock_decrease() {
        stockService.decrease(1L, 1L)

        //예상: 100 - 1 = 99
        val stock = stockRepository.findByIdOrNull(1L) ?: throw RuntimeException("재고를 찾을 수 없습니다.")
        assertEquals(99, stock.quantity)
    }

    @Test
    @DisplayName("동시에 100개 요청")
    fun stock_decrease_concurrency() {
        val threadCount = 100

        //ExecutorService: 비동기 작업을 단순화하여 사용하도록 하는 java api
        val executorService : ExecutorService = Executors.newFixedThreadPool(32)

        //CountDownLatch: 다른 쓰레드에서 수행중인 작업이 완료될 때까지 대기하는 역할
        val latch = CountDownLatch(threadCount)

        for (i in 0..threadCount) {
            executorService.submit {
                try {
                    //stockService.decrease(1L, 1L)
                    //stockService.decreaseSynchronized(1L, 1L)
                    stockService.decreaseSynchronizedOnly(1L, 1L)
                } finally {
                    latch.countDown()
                }
            }
        }
        latch.await()

        //예상: 100 - (1 * 100) = 0
        val stock = stockRepository.findByIdOrNull(1L) ?: throw RuntimeException("재고를 찾을 수 없습니다.")
        assertEquals(0L, stock.quantity)

        /*
        [실패 이유] - 경쟁 상태(Race Condition)
        경쟁 상태란 둘 이상의 입력 또는 조작의 타이밍이나 순서 등이 결과값에 영향을 줄 수 있는 상태를 말한다.
        입력 변화의 타이밍이나 순서가 예상과 다르게 작동하면 정상적인 결과가 나오지 않게 될 위험이 있는데 이를 경쟁 위험이라고 한다. - 위키백과

        [해결 방법1] - @Synchronized
        @Synchronized를 사용하면 해당 메소드에 1개의 쓰레드만 접근이 가능하다.

        단, @Transactional과 함께 쓸 수 없다.
        @Transactional를 사용하면 Spring에서 @Transactional를 랩핑한 클래스를 새로 만들어서 실행한다.
        트랜잭션 종료(업데이트가 수행되는 시점)하기 이전에 다른 쓰레드에서 decrease()를 호출할 수 있고, 갱신 이전의 값을 가져가기 때문에
        데이터일관성이 깨지게 된다.

        [해결 방법1 - 문제점] - 멑리 서버 환경에서는 보장되지 않는다.
        @Synchronized는 하나의 개별 프로세스 안에서만 보장이 된다. 서버가 1대의 경우에는 문제가 없지만,
        서버가 1대 이상인 경우 데이터의 접근을 여러 대에서 할 수 있다는 문제가 발생한다.
        */
    }

}