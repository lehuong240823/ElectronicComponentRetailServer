package org.example.electroniccomponentretailserver.service

import org.example.electroniccomponentretailserver.entity.VoucherType
import org.example.electroniccomponentretailserver.repository.VoucherTypeRepository
import org.example.electroniccomponentretailserver.updateEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class VoucherTypeService(private val voucherTypeRepository: VoucherTypeRepository) {

    fun getAllVoucherTypes(pageable: Pageable): Page<VoucherType> = voucherTypeRepository.findAll(pageable)

    fun getVoucherTypeById(id: Byte): VoucherType? = voucherTypeRepository.findById(id).orElse(null)

    fun saveVoucherType(role: VoucherType): VoucherType = voucherTypeRepository.save(role)

    fun updateVoucherType(id: Byte, updatedVoucherType: VoucherType): VoucherType? {
        return if (voucherTypeRepository.existsById(id)) {
            val existingVoucherType: VoucherType = voucherTypeRepository.findById(id).get()
            updateEntity(existingVoucherType, updatedVoucherType)
            voucherTypeRepository.save(existingVoucherType)
        } else {
            null
        }
    }

    fun deleteVoucherType(id: Byte) = voucherTypeRepository.deleteById(id)
}