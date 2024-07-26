package com.example.citasmed.service

import com.example.citasmed.model.Appoinments
import com.example.citasmed.model.Doctor
import com.example.citasmed.repository.AppoinmentsRepository
import com.example.citasmed.repository.DoctorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AppoinmentsService {
    @Autowired
    lateinit var appoinmentsRepository: AppoinmentsRepository

    fun list (): List<Appoinments> {
        return appoinmentsRepository.findAll()
    }

    fun listById(id: Long): Appoinments {
        return appoinmentsRepository.findById(id)
        .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Cita con el $id no Encontrado" )}
    }

    fun save(appoinments: Appoinments): Appoinments {
        return appoinmentsRepository.save(appoinments)
    }

    fun update(appoinments: Appoinments): Appoinments {
        val existingAppoinments = appoinmentsRepository.findById(appoinments.id)
            .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND , "Cita con el ${appoinments.id} no Encontrado" )}
        existingAppoinments.createdAt = appoinments.createdAt
        return appoinmentsRepository.save(existingAppoinments)
    }

    fun updateReason(appoinments: Appoinments): Appoinments {
       val existingAppoinments = appoinmentsRepository.findById(appoinments.id)
           .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND,"Cita con el ${appoinments.id} no Encontrado" )}
        existingAppoinments.reason = appoinments.reason
        return appoinmentsRepository.save(existingAppoinments)
    }
    fun delete(id: Long) {
      if(!appoinmentsRepository.existsById(id)){
          throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cita con el $id no Encontrado")
      }
        appoinmentsRepository.deleteById(id)
    }

}