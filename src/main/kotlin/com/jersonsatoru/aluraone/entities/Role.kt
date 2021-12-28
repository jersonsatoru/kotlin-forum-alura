package com.jersonsatoru.aluraone.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import org.springframework.security.core.GrantedAuthority

@Entity
data class Role (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    private val name: String
) :GrantedAuthority {
    override fun getAuthority() = name
}
