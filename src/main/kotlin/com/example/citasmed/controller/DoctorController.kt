package com.example.citasmed.controller

import com.example.citasmed.model.Doctor
import com.example.citasmed.service.DoctorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/doctor")
class DoctorController {
    @Autowired
    lateinit var doctorService: DoctorService

    @GetMapping
    fun list(): List<Doctor> {
        return doctorService.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): Doctor {
        return doctorService.listById(id)
    }

    @PostMapping
    fun save(@RequestBody doctor: Doctor): Doctor {
        return doctorService.save(doctor)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long?, @RequestBody doctor: Doctor?):ResponseEntity<Doctor> {
        val updateDoctor = doctorService.update(doctor!!)
        return ResponseEntity.ok(updateDoctor)
    }
    @PatchMapping("/{id}")
    fun updateDoctor(@PathVariable id: Long?, @RequestBody doctor: Doctor?): ResponseEntity<Doctor> {
        val updateDoctor= doctorService.updateName(doctor!!)
        return ResponseEntity.ok(updateDoctor)
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        doctorService.delete(id)
    }
}
