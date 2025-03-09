package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.UserAddress
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface UserAddressRepository: JpaRepository<UserAddress, Int> {
    override fun findAll(pageable: Pageable): Page<UserAddress>
}