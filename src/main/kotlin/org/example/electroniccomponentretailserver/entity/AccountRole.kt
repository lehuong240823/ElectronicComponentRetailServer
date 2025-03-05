package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*

@Entity
@Table(name = "account_role", schema = "e-commerce")
class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_role_id", nullable = false)
    var id: Byte? = null

    @Column(name = "name", nullable = false, length = 50)
    var name: String? = null
}