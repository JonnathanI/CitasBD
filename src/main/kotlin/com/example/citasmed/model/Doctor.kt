package com.example.citasmed.model

import jakarta.persistence.*

@Entity
@Table(name = "doctor")
class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    var nui: String? = null
    @Column(name = "fullname")
    var fullName: String? = null
    var phone: String? = null
    var specilization: String? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patients_id")
    var patients:Patients? = null
}