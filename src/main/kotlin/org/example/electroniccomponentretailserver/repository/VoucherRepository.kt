package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Voucher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface VoucherRepository: JpaRepository<Voucher, Int> {
    override fun findAll(pageable: Pageable): Page<Voucher>
}