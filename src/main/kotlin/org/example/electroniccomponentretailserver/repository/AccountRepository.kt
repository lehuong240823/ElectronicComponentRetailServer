package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Int> {
}