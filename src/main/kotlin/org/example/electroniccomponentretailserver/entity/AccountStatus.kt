package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*

@Entity
@Table(name = "account_status", schema = "e-commerce")
class AccountStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_status_id", nullable = false)
    var id: Byte? = null

    @Column(name = "name", nullable = false, length = 50)
    var name: String? = null
}