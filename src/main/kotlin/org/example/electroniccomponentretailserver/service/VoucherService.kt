package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.Voucher
import org.example.electroniccomponentretailserver.repository.VoucherRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class VoucherService(private val voucherRepository: VoucherRepository) {

    fun getAllVouchers(pageable: Pageable): Page<Voucher> = voucherRepository.findAll(pageable)

    fun getVoucherById(id: Int): Voucher? = voucherRepository.findById(id).orElse(null)

    @Transactional
    fun saveVoucher(role: Voucher): Voucher = voucherRepository.save(role)

    @Transactional
    fun updateVoucher(id: Int, updatedVoucher: Voucher): Voucher? {
        return if (voucherRepository.existsById(id)) {
            val existingVoucher: Voucher = voucherRepository.findById(id).get()
            updateEntity(existingVoucher, updatedVoucher)
            voucherRepository.save(existingVoucher)
        } else {
            null
        }
    }

    fun deleteVoucher(id: Int) = voucherRepository.deleteById(id)

    fun getVouchersByVoucherTypeId(pageable: Pageable, voucherTypeId: Byte): Page<Voucher> = voucherRepository.findVouchersByVoucherType_Id(pageable, voucherTypeId)
}