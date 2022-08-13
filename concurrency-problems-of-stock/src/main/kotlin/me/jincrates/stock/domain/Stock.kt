package me.jincrates.stock.domain

import java.lang.RuntimeException
import javax.persistence.*

@Entity
@Table(name = "stock")
class Stock (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var productId: Long,

    var quantity: Long,

) {

    /**
     * 재고 감소
     */
    fun decrease(quantity: Long) {
        if (this.quantity - quantity < 0) {
            throw RuntimeException("재고가 0보다 작을 수 없습니다.")
        }

        this.quantity -= quantity
    }
}
