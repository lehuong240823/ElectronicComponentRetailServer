package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.AccountRole
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRoleRepository : JpaRepository<AccountRole, Byte> {
}