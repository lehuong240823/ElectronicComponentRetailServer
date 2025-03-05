package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "user_address", schema = "e-commerce", indexes = [
    Index(name = "user_id", columnList = "user_id")
])
class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_address_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null

    @Column(name = "name", length = 100)
    var name: String? = null

    @Column(name = "street", nullable = false)
    var street: String? = null

    @Column(name = "ward", length = 100)
    var ward: String? = null

    @Column(name = "commune", length = 100)
    var commune: String? = null

    @Column(name = "district", nullable = false, length = 100)
    var district: String? = null

    @Column(name = "city", length = 100)
    var city: String? = null

    @Column(name = "province", nullable = false, length = 100)
    var province: String? = null

    @Column(name = "postal_code", length = 100)
    var postalCode: String? = null

    @Column(name = "latitute", precision = 9, scale = 6)
    var latitute: BigDecimal? = null

    @Column(name = "longtitude", precision = 9, scale = 6)
    var longtitude: BigDecimal? = null

    @Column(name = "is_default", nullable = false)
    var isDefault: Boolean? = false
}