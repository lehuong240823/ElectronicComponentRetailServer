package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Transaction
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository: JpaRepository<Transaction, Int> {
    override fun findAll(pageable: Pageable): Page<Transaction>
}