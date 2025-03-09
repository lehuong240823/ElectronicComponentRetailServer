package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.TransactionStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionStatusRepository: JpaRepository<TransactionStatus, Byte> {
    override fun findAll(pageable: Pageable): Page<TransactionStatus>
}