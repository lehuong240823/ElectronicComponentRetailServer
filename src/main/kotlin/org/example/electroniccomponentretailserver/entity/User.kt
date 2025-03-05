package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*

@Entity
@Table(name = "user", schema = "e-commerce")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    var id: Int? = null

    @Column(name = "account_id", nullable = false)
    var accountId: Int? = null

    @Column(name = "full_name", nullable = false, length = 100)
    var fullName: String? = null
}