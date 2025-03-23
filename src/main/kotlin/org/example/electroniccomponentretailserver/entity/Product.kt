package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.math.BigDecimal
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(
    name = "product", schema = "e-commerce", indexes = [
        Index(name = "category_id", columnList = "category_id"),
        Index(name = "provider_id", columnList = "provider_id"),
        Index(name = "product_status_id", columnList = "product_status_id")
    ]
)
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "category_id")
    //@JsonIgnore
    var category: Category? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "provider_id")
    //@JsonIgnore
    var provider: Provider? = null

    @Column(name = "name", nullable = false, length = 100)
    var name: String? = null

    @Lob
    @Column(name = "description")
    var description: String? = null

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    var price: BigDecimal? = null

    @Column(name = "stock", nullable = false)
    var stock: Int? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_status_id", nullable = false)
    var productStatus: ProductStatus? = null
}