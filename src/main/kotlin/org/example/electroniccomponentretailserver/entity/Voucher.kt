package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.math.BigDecimal
import java.time.Instant
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(
    name = "voucher", schema = "e-commerce", indexes = [
        Index(name = "voucher_type_id", columnList = "voucher_type_id")
    ], uniqueConstraints = [
        UniqueConstraint(name = "code", columnNames = ["code"])
    ]
)
class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_id", nullable = false)
    var id: Int? = null

    @Column(name = "code", nullable = false, length = 50)
    var code: String? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "voucher_type_id", nullable = false)
    var voucherType: VoucherType? = null

    @Column(name = "discount_value", nullable = false, precision = 15, scale = 2)
    var discountValue: BigDecimal? = null

    @ColumnDefault("1")
    @Column(name = "max_uses", nullable = false)
    var maxUses: Int? = null

    @ColumnDefault("0")
    @Column(name = "used_count", nullable = false)
    var usedCount: Int? = null

    @ColumnDefault("0.00")
    @Column(name = "min_order", precision = 15, scale = 2)
    var minOrder: BigDecimal? = null

    @ColumnDefault("0.00")
    @Column(name = "max_discount", precision = 15, scale = 2)
    var maxDiscount: BigDecimal? = null

    @Column(name = "valid_from")
    var validFrom: Instant? = null

    @Column(name = "valid_until")
    var validUntil: Instant? = null

    @ColumnDefault("1")
    @Column(name = "is_active")
    var isActive: Boolean? = null
}