package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.math.BigDecimal
import java.time.Instant
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(
    name = "orders", schema = "e-commerce", indexes = [
        Index(name = "user_id", columnList = "user_id"),
        Index(name = "order_status_id", columnList = "order_status_id"),
        Index(name = "user_address_id", columnList = "user_address_id"),
        Index(name = "voucher_id", columnList = "voucher_id")
    ]
)
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    //@JsonIgnore
    var user: User? = null

    @Column(name = "amount", nullable = false, precision = 20, scale = 2)
    var amount: BigDecimal? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "order_status_id", nullable = false)
    var orderStatus: OrderStatus? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "user_address_id")
    //@JsonIgnore
    var userAddress: UserAddress? = null

    @Column(name = "address", nullable = false, length = 500)
    var address: String? = null

    @Column(name = "tracking_number", length = 50)
    var trackingNumber: String? = null

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    var createdAt: Instant? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "voucher_id")
    //@JsonIgnore
    var voucher: Voucher? = null
}