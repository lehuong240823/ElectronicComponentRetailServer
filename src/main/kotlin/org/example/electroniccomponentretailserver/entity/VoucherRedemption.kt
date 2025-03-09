package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.Instant
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(
    name = "voucher_redemption", schema = "e-commerce", indexes = [
        Index(name = "user_id", columnList = "user_id")
    ], uniqueConstraints = [
        UniqueConstraint(name = "voucher_id", columnNames = ["voucher_id", "user_id"])
    ]
)
class VoucherRedemption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_redemption_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "voucher_id", nullable = false)
    @JsonIgnore
    var voucher: Voucher? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    var user: User? = null

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "used_at")
    var usedAt: Instant? = null
}