package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.AccessLevel
import org.springframework.data.jpa.repository.JpaRepository

interface AccessLevelRepository: JpaRepository<AccessLevel, Byte> {
}