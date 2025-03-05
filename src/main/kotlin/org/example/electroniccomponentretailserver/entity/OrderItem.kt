package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.math.BigDecimal

@Entity
@Table(name = "order_item", schema = "e-commerce", indexes = [
    Index(name = "order_id", columnList = "order_id"),
    Index(name = "product_id", columnList = "product_id")
])
class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    var order: Order? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "product_id")
    var product: Product? = null

    @Column(name = "product_name")
    var productName: String? = null

    @Column(name = "quantity", nullable = false)
    var quantity: Int? = null

    @Column(name = "price", nullable = false, precision = 15, scale = 2)
    var price: BigDecimal? = null
}