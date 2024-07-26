package com.example.citasmed.service

import com.example.citasmed.model.Doctor
import com.example.citasmed.model.Patients
import com.example.citasmed.repository.DoctorRepository
import com.example.citasmed.repository.PatientsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PatientsService {
    @Autowired
    lateinit var patientsRepository: PatientsRepository

    fun list (): List<Patients> {
        return patientsRepository.findAll()
    }

    fun listById(id: Long): Patients {
        return patientsRepository.findById(id)
        .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente con el $id no Encontrado" )}
    }

    fun save(patients: Patients): Patients {
        return patientsRepository.save(patients)
    }

    fun update(patients: Patients): Patients {
        val existingPatients = patientsRepository.findById(patients.id)
            .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND , "Paciente con el ${patients.id} no Encontrado" )}
        existingPatients.nui = patients.nui
        return patientsRepository.save(existingPatients)
    }

    fun updateName(patients: Patients): Patients {
       val existingPatients = patientsRepository.findById(patients.id)
           .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND,"Paciente con el ${patients.id} no Encontrado" )}
        existingPatients.fullName = patients.fullName
        return patientsRepository.save(existingPatients)
    }
    fun delete(id: Long) {
      if(!patientsRepository.existsById(id)){
          throw ResponseStatusException(HttpStatus.NOT_FOUND, "Pciente con el $id no Encontrado")
      }
        patientsRepository.deleteById(id)
    }

}