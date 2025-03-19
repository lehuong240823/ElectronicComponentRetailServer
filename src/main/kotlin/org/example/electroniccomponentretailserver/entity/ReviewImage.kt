package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(
    name = "review_image", schema = "e-commerce", indexes = [
        Index(name = "review_id", columnList = "review_id")
    ]
)
class ReviewImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_image_id", nullable = false)
    var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "review_id", nullable = false)
    @JsonIgnore
    var review: Review? = null
}