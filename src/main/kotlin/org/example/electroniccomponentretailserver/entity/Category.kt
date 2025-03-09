package org.example.electroniccomponentretailserver.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(name = "category", schema = "e-commerce")
class Category {
    @Id
    @Column(name = "category_id", nullable = false)
    var id: Int? = null

    @Column(name = "name", nullable = false, length = 50)
    var name: String? = null

    @Column(name = "image")
    var image: String? = null
}