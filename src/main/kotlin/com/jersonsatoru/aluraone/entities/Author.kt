package com.jersonsatoru.aluraone.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
data class Author(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
        val name: String,
        val email: String,
        val password: String,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinColumn(name = "author_role")
        @JsonIgnore()
        val roles: List<Role> = mutableListOf()
)
