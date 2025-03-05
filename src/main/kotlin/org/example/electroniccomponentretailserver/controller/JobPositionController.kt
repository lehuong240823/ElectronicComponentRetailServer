package org.example.electroniccomponentretailserver.controller

import org.example.electroniccomponentretailserver.entity.JobPosition
import org.example.electroniccomponentretailserver.service.JobPositionService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/job-positions")
class JobPositionController(private val jobPositionService: JobPositionService) {

    @GetMapping
    fun getAllJobPositions(): List<JobPosition> = jobPositionService.getAllJobPositions()

    @GetMapping("/{id}")
    fun getJobPositionById(@PathVariable id: Byte): ResponseEntity<JobPosition> {
        val jobPosition = jobPositionService.getJobPositionById(id)
        return if (jobPosition != null) ResponseEntity.ok(jobPosition) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createJobPosition(@RequestBody jobPosition: JobPosition): JobPosition = jobPositionService.saveJobPosition(jobPosition)

    @PutMapping("/{id}")
    fun updateJobPosition(@PathVariable id: Byte, @RequestBody updatedJobPosition: JobPosition): ResponseEntity<JobPosition> {
        val jobPosition = jobPositionService.updateJobPosition(id, updatedJobPosition)
        return if (jobPosition != null) ResponseEntity.ok(jobPosition) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteJobPosition(@PathVariable id: Byte): ResponseEntity<Void> {
        jobPositionService.deleteJobPosition(id)
        return ResponseEntity.noContent().build()
    }
}