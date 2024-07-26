package com.example.citasmed.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "appoinments")
class Appoinments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    @Column(name = "created_at")
    var createdAt: Date? = null
    var reason: String? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "patients_id")
    var patients:Patients? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "doctor_id")
    var doctor:Doctor? = null
}