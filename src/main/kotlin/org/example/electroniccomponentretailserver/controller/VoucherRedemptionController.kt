package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.VoucherRedemption
import org.example.electroniccomponentretailserver.service.VoucherRedemptionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/voucher-redemptions")
class VoucherRedemptionController(private val voucherRedemptionService: VoucherRedemptionService) {

    @GetMapping
    fun getAllVoucherRedemptions(@PageableDefault(size = 10) pageable: Pageable): Page<VoucherRedemption> = voucherRedemptionService.getAllVoucherRedemptions(pageable)

    @GetMapping("/{id}")
    fun getVoucherRedemptionById(@PathVariable id: Int): ResponseEntity<VoucherRedemption> {
        val voucherRedemption = voucherRedemptionService.getVoucherRedemptionById(id)
        return if (voucherRedemption != null) ResponseEntity.ok(voucherRedemption) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createVoucherRedemption(@RequestBody voucherRedemption: VoucherRedemption): VoucherRedemption = voucherRedemptionService.saveVoucherRedemption(voucherRedemption)

    @PutMapping("/{id}")
    fun updateVoucherRedemption(@PathVariable id: Int, @RequestBody updatedVoucherRedemption: VoucherRedemption): ResponseEntity<VoucherRedemption> {
        val voucherRedemption = voucherRedemptionService.updateVoucherRedemption(id, updatedVoucherRedemption)
        return if (voucherRedemption != null) ResponseEntity.ok(voucherRedemption) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteVoucherRedemption(@PathVariable id: Int): ResponseEntity<Void> {
        voucherRedemptionService.deleteVoucherRedemption(id)
        return ResponseEntity.noContent().build()
    }
}