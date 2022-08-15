package me.jincrates.concurrencyproblems.facade

import me.jincrates.concurrencyproblems.domain.LectureReservation
import me.jincrates.concurrencyproblems.repository.LectureReservationRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
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
class OptimisticLockFacadeTest {

    @Autowired lateinit var optimisticLockFacade: OptimisticLockFacade
    @Autowired lateinit var lectureReservationRepository: LectureReservationRepository

    @BeforeEach
    fun before() {
        val lectureReservation = LectureReservation(
            lectureId = 1L,
            limitOfReservations = 100L,
            currentNumberOfReservations = 0L
        )
        lectureReservationRepository.saveAndFlush(lectureReservation)
    }

    @AfterEach
    fun after() = lectureReservationRepository.deleteAll()

    @Disabled @Test
    @DisplayName("동시에 100개 요청 - Optimistic Lock을 사용한 문제 해결")
    fun add_reservations_concurrency() {
        val threadCount = 100

        //ExecutorService: 비동기 작업을 단순화하여 사용하도록 하는 java api
        val executorService : ExecutorService = Executors.newFixedThreadPool(32)

        //CountDownLatch: 다른 쓰레드에서 수행중인 작업이 완료될 때까지 대기하는 역할
        val latch = CountDownLatch(threadCount)

        for (i in 0 .. threadCount) {
            executorService.submit {
                try {
                    optimisticLockFacade.addReservations(1L, 1L)
                } finally {
                    latch.countDown()
                }
            }
        }
        latch.await()

        // 예상: 1번씩 100개의 요청을 했으니, 현재 예약자 수는 100명일 것이다.
        val lectureReservation = lectureReservationRepository.findByIdOrNull(1L) ?: throw RuntimeException("예약정보를 찾을 수 없습니다.")
        assertEquals(100L, lectureReservation.currentNumberOfReservations)

        /*
        */
    }
}