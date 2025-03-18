package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.VoucherRedemption
import org.example.electroniccomponentretailserver.repository.VoucherRedemptionRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class VoucherRedemptionService(private val voucherRedemptionRepository: VoucherRedemptionRepository) {

    fun getAllVoucherRedemptions(pageable: Pageable): Page<VoucherRedemption> = voucherRedemptionRepository.findAll(pageable)

    fun getVoucherRedemptionById(id: Int): VoucherRedemption? = voucherRedemptionRepository.findById(id).orElse(null)

    fun saveVoucherRedemption(role: VoucherRedemption): VoucherRedemption = voucherRedemptionRepository.save(role)

    fun updateVoucherRedemption(id: Int, updatedVoucherRedemption: VoucherRedemption): VoucherRedemption? {
        return if (voucherRedemptionRepository.existsById(id)) {
            val existingVoucherRedemption: VoucherRedemption = voucherRedemptionRepository.findById(id).get()
            updateEntity(existingVoucherRedemption, updatedVoucherRedemption)
            voucherRedemptionRepository.save(existingVoucherRedemption)
        } else {
            null
        }
    }

    fun deleteVoucherRedemption(id: Int) = voucherRedemptionRepository.deleteById(id)

    fun getVoucherRedemptionsByVoucherId(pageable: Pageable, voucherId: Int): Page<VoucherRedemption> = voucherRedemptionRepository.findVoucherRedemptionsByVoucher_Id(pageable, voucherId)

    fun getVoucherRedemptionsByUserId(pageable: Pageable, userId: Int): Page<VoucherRedemption> = voucherRedemptionRepository.findVoucherRedemptionsByUser_Id(pageable, userId)
}