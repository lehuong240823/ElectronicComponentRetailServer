package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(
    name = "provider", schema = "e-commerce", uniqueConstraints = [
        UniqueConstraint(name = "email", columnNames = ["email"])
    ]
)
class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id", nullable = false)
    var id: Int? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "type")
    var type: String? = null

    @Column(name = "email", nullable = false, length = 50)
    var email: String? = null

    @Column(name = "phone_number", length = 15)
    var phoneNumber: String? = null

    @Column(name = "address")
    var address: String? = null
}