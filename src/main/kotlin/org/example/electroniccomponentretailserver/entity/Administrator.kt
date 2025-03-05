package org.example.electroniccomponentretailserver.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
@Table(name = "administrator", schema = "e-commerce", indexes = [
    Index(name = "account_id", columnList = "account_id"),
    Index(name = "job_position_id", columnList = "job_position_id"),
    Index(name = "access_level_id", columnList = "access_level_id")
])
class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "account_id", nullable = false)
    @JsonIgnore
    var account: Account? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "job_position_id")
    var jobPosition: JobPosition? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "access_level_id", nullable = false)
    var accessLevel: AccessLevel? = null
}