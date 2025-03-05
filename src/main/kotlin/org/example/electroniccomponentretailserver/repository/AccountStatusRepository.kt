package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.AccountStatus
import org.springframework.data.jpa.repository.JpaRepository

interface AccountStatusRepository : JpaRepository<AccountStatus, Byte> {
}