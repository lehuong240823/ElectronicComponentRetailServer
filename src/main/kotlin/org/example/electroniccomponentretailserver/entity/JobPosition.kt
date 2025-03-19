package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(
    name = "job_position", schema = "e-commerce", uniqueConstraints = [
        UniqueConstraint(name = "name", columnNames = ["name"])
    ]
)
class JobPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_position_id", nullable = false)
    var id: Byte? = null

    @Column(name = "name", nullable = false, length = 100)
    var name: String? = null
}