package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(
    name = "review", schema = "e-commerce", indexes = [
        Index(name = "user_id", columnList = "user_id"),
        Index(name = "order_item_id", columnList = "order_item_id"),
        Index(name = "product_id", columnList = "product_id")
    ]
)
class Review {
    @Id
    @Column(name = "review_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    var user: User? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_item_id", nullable = false)
    @JsonIgnore
    var orderItem: OrderItem? = null

    @ColumnDefault("5")
    @Column(name = "rating", nullable = false)
    var rating: Int? = null

    @Lob
    @Column(name = "content")
    var content: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    var product: Product? = null
}