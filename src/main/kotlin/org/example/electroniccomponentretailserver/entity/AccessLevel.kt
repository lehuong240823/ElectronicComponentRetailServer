package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*

@Entity
@Table(name = "access_level", schema = "e-commerce")
class AccessLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "access_level_id", nullable = false)
    var id: Byte? = null

    @Column(name = "name", nullable = false, length = 50)
    var name: String? = null
}