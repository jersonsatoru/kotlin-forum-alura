package com.jersonsatoru.aluraone.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity()
data class Course(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
        val name: String,
        val category: String,
)
