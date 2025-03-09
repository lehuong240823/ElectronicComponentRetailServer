package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.VoucherType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface VoucherTypeRepository: JpaRepository<VoucherType, Byte> {
    override fun findAll(pageable: Pageable): Page<VoucherType>
}