package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(name = "account_role", schema = "e-commerce")
class AccountRole {
    @Id
    @Column(name = "account_role_id", nullable = false)
    var id: Byte? = null

    @Column(name = "name", nullable = false, length = 50)
    var name: String? = null
}