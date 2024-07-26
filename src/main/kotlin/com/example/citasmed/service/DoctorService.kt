package com.example.citasmed.service

import com.example.citasmed.model.Doctor
import com.example.citasmed.repository.DoctorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DoctorService {
    @Autowired
    lateinit var doctorRepository: DoctorRepository

    fun list (): List<Doctor> {
        return doctorRepository.findAll()
    }

    fun listById(id: Long): Doctor {
        return doctorRepository.findById(id)
        .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor con el $id no Encontrado" )}
    }

    fun save(doctor: Doctor): Doctor {
        return doctorRepository.save(doctor)
    }

    fun update(doctor: Doctor): Doctor {
        val existingDoctor = doctorRepository.findById(doctor.id)
            .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND , "Doctor con el ${doctor.id} no Encontrado" )}
        existingDoctor.nui = doctor.nui
        return doctorRepository.save(existingDoctor)
    }

    fun updateName(doctor: Doctor): Doctor {
       val existingDoctor = doctorRepository.findById(doctor.id)
           .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND,"Doctor con el ${doctor.id} no Encontrado" )}
        existingDoctor.nui = doctor.nui
        return doctorRepository.save(existingDoctor)
    }
    fun delete(id: Long) {
      if(!doctorRepository.existsById(id)){
          throw ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor con el $id no Encontrado")
      }
        doctorRepository.deleteById(id)
    }

}