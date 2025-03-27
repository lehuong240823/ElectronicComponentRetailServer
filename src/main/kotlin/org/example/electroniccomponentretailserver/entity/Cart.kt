package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.Instant
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(
    name = "cart", schema = "e-commerce", indexes = [
        Index(name = "product_id", columnList = "product_id")
    ], uniqueConstraints = [
        UniqueConstraint(name = "user_id", columnNames = ["user_id", "product_id"])
    ]
)
class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_id", nullable = false)
    var product: Product? = null

    @ColumnDefault("1")
    @Column(name = "quantity", nullable = false)
    var quantity: Int? = null

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "added_at", nullable = false)
    var addedAt: Instant? = null
}