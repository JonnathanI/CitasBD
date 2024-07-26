package com.example.citasmed.controller

import com.example.citasmed.model.Doctor
import com.example.citasmed.model.Secretaria
import com.example.citasmed.service.DoctorService
import com.example.citasmed.service.SecretariaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/secretaria")
class SecretariaController {
    @Autowired
    lateinit var secretariaService: SecretariaService

    @GetMapping
    fun list(): List<Secretaria> {
        return secretariaService.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): Secretaria {
        return secretariaService.listById(id)
    }

    @PostMapping
    fun save(@RequestBody secretaria: Secretaria): Secretaria {
        return secretariaService.save(secretaria)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long?, @RequestBody secretaria: Secretaria?):ResponseEntity<Secretaria> {
        val updateSecretaria = secretariaService.update(secretaria!!)
        return ResponseEntity.ok(updateSecretaria)
    }
    @PatchMapping("/{id}")
    fun updateDoctor(@PathVariable id: Long?, @RequestBody secretaria: Secretaria?): ResponseEntity<Secretaria> {
        val updateSecretaria= secretariaService.updateName(secretaria!!)
        return ResponseEntity.ok(updateSecretaria)
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        secretariaService.delete(id)
    }
}
