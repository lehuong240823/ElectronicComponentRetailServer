package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(
    name = "payment_method", schema = "e-commerce", uniqueConstraints = [
        UniqueConstraint(name = "name", columnNames = ["name"])
    ]
)
class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id", nullable = false)
    var id: Byte? = null

    @Column(name = "name", nullable = false, length = 50)
    var name: String? = null
}