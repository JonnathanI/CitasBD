package com.example.citasmed.controller

import com.example.citasmed.model.Appoinments
import com.example.citasmed.model.Doctor
import com.example.citasmed.service.AppoinmentsService
import com.example.citasmed.service.DoctorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/appoinments")
class AppoinmentsController {
    @Autowired
    lateinit var appoinmentsService: AppoinmentsService

    @GetMapping
    fun list(): List<Appoinments> {
        return appoinmentsService.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): Appoinments {
        return appoinmentsService.listById(id)
    }

    @PostMapping
    fun save(@RequestBody appoinments: Appoinments): Appoinments {
        return appoinmentsService.save(appoinments)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long?, @RequestBody appoinments: Appoinments?):ResponseEntity<Appoinments> {
        val updateAppoinments = appoinmentsService.update(appoinments!!)
        return ResponseEntity.ok(updateAppoinments)
    }
    @PatchMapping("/{id}")
    fun updateReason(@PathVariable id: Long?, @RequestBody appoinments: Appoinments?): ResponseEntity<Appoinments> {
        val updateAppoinments= appoinmentsService.updateReason(appoinments!!)
        return ResponseEntity.ok(updateAppoinments)
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        appoinmentsService.delete(id)
    }
}
