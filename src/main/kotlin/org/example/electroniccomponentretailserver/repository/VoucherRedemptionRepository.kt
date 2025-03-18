package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.VoucherRedemption
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface VoucherRedemptionRepository: JpaRepository<VoucherRedemption, Int> {
    override fun findAll(pageable: Pageable): Page<VoucherRedemption>
    fun findVoucherRedemptionsByVoucher_Id(pageable: Pageable, voucherId: Int): Page<VoucherRedemption>
    fun findVoucherRedemptionsByUser_Id(pageable: Pageable, userId: Int): Page<VoucherRedemption>
}