package com.example.citasmed.controller

import com.example.citasmed.model.Doctor
import com.example.citasmed.model.Patients
import com.example.citasmed.service.DoctorService
import com.example.citasmed.service.PatientsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/patients")
class PatientsController {
    @Autowired
    lateinit var patientsService: PatientsService

    @GetMapping
    fun list(): List<Patients> {
        return patientsService.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): Patients {
        return patientsService.listById(id)
    }

    @PostMapping
    fun save(@RequestBody patients: Patients): Patients {
        return patientsService.save(patients)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long?, @RequestBody patients: Patients?):ResponseEntity<Patients> {
        val updatePatients = patientsService.update(patients!!)
        return ResponseEntity.ok(updatePatients)
    }
    @PatchMapping("/{id}")
    fun updateDoctor(@PathVariable id: Long?, @RequestBody patients: Patients?): ResponseEntity<Patients> {
        val updatePatients= patientsService.updateName(patients!!)
        return ResponseEntity.ok(updatePatients)
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        patientsService.delete(id)
    }
}
