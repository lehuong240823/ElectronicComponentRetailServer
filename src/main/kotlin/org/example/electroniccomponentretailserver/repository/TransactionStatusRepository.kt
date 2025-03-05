package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.TransactionStatus
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionStatusRepository : JpaRepository<TransactionStatus, Byte> {
}