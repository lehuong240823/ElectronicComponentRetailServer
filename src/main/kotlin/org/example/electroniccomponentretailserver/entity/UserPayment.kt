package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(name = "user_payment", schema = "e-commerce", indexes = [
    Index(name = "user_id", columnList = "user_id"),
    Index(name = "payment_method_id", columnList = "payment_method_id")
])
class UserPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_payment_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    var user: User? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "payment_method_id", nullable = false)
    var paymentMethod: PaymentMethod? = null

    @Column(name = "bank_code", nullable = false, length = 20)
    var bankCode: String? = null

    @Column(name = "account_number", nullable = false)
    var accountNumber: String? = null

    @Column(name = "is_default", nullable = false)
    var isDefault: Boolean? = false
}