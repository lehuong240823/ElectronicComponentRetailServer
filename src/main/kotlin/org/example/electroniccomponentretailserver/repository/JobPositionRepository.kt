package org.example.electroniccomponentretailserver.repository

import org.example.electroniccomponentretailserver.entity.JobPosition
import org.springframework.data.jpa.repository.JpaRepository

interface JobPositionRepository : JpaRepository<JobPosition, Byte> {
}