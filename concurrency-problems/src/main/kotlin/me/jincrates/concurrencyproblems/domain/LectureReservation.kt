package me.jincrates.concurrencyproblems.domain

import java.lang.RuntimeException
import javax.persistence.*

@Entity
class LectureReservation (

    //예약 ID
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    //강연 ID
    val lectureId: Long,

    //예약 마감인원
    var limitOfReservations: Long,

    //현재 예약자 수
    var currentNumberOfReservations: Long,

    @Version
    var version: Long? = null,
) {

    /**
     * 예약자 추가
     */
    fun addReservation(count: Long) {
        if ( this.limitOfReservations < this.currentNumberOfReservations + count) {
            throw RuntimeException("예약 마감인원보다 클 수 없습니다.")
        }

        this.currentNumberOfReservations += count
    }
}