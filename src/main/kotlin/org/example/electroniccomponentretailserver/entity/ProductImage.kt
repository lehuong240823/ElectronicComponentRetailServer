package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(
    name = "product_image", schema = "e-commerce", indexes = [
        Index(name = "product_id", columnList = "product_id")
    ]
)
class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_id", nullable = false)
    var product: Product? = null

    @Column(name = "url", nullable = false)
    var url: String? = null
}