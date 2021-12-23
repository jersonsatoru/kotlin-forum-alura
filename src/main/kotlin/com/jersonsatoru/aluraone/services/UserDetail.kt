package com.jersonsatoru.aluraone.services

import com.jersonsatoru.aluraone.entities.Author
import org.springframework.security.core.userdetails.UserDetails

class UserDetail(private val author: Author) : UserDetails {
    override fun getAuthorities() = null
    override fun getPassword(): String = author.password
    override fun getUsername(): String = author.email
    override fun isAccountNonExpired(): Boolean = true
    override fun isAccountNonLocked(): Boolean = true
    override fun isCredentialsNonExpired(): Boolean = true
    override fun isEnabled(): Boolean = true
}
