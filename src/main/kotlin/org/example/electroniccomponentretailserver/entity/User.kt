package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(
    name = "user", schema = "e-commerce", indexes = [
        Index(name = "account_id", columnList = "account_id")
    ]
)
class User {
    @Id
    @Column(name = "user_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    @JsonIgnore
    var account: Account? = null

    @Column(name = "full_name", nullable = false, length = 100)
    var fullName: String? = null
}