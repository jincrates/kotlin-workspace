package me.jincrates.concurrencyproblems.service

import me.jincrates.concurrencyproblems.domain.LectureReservation
import me.jincrates.concurrencyproblems.facade.LettuceLockFacade
import me.jincrates.concurrencyproblems.facade.OptimisticLockFacade
import me.jincrates.concurrencyproblems.facade.RedissonLockFacade
import me.jincrates.concurrencyproblems.repository.LectureReservationRepository
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import java.lang.RuntimeException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@SpringBootTest
class LectureReservationServiceTest {

    @Autowired lateinit var lectureReservationService: LectureReservationService
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

    @Test
    @DisplayName("예약 신청 테스트")
    fun add_reservation() {
        lectureReservationService.addReservations(1L, 1L)

        //예상: 0 + 1 = 1
        val lectureReservation = lectureReservationRepository.findByIdOrNull(1L) ?: throw RuntimeException("예약정보를 찾을 수 없습니다.")
        assertEquals(1, lectureReservation.currentNumberOfReservations)
    }

    @Test
    @DisplayName("동시에 100개 요청 - 동시성 제어X")
    fun add_reservations_concurrency1() {
        val threadCount = 100

        //ExecutorService: 비동기 작업을 단순화하여 사용하도록 하는 java api
        val executorService : ExecutorService = Executors.newFixedThreadPool(32)

        //CountDownLatch: 다른 쓰레드에서 수행중인 작업이 완료될 때까지 대기하는 역할
        val latch = CountDownLatch(threadCount)

        for (i in 0 .. threadCount) {
            executorService.submit {
                try {
                    lectureReservationService.addReservations(1L, 1L)
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
        [실패 이유] - 경쟁 상태(Race Condition)
        경쟁 상태란 둘 이상의 입력 또는 조작의 타이밍이나 순서 등이 결과값에 영향을 줄 수 있는 상태를 말한다.
        입력 변화의 타이밍이나 순서가 예상과 다르게 작동하면 정상적인 결과가 나오지 않게 될 위험이 있는데 이를 경쟁 위험이라고 한다. - 위키백과
        */
    }
}