package com.jersonsatoru.aluraone.services

import com.jersonsatoru.aluraone.entities.Author
import com.jersonsatoru.aluraone.exceptions.NotFoundException
import com.jersonsatoru.aluraone.repositories.AuthorRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthorService(private val authorRepository: AuthorRepository) : UserDetailsService {
    fun getById(id: Long): Author =
            authorRepository.findById(id).orElseThrow {
                throw NotFoundException("Author not found")
            }

    override fun loadUserByUsername(username: String): UserDetails {
        val author: Author =
                authorRepository.findByEmail(username)
                        ?: throw NotFoundException("Author not found")
        return UserDetail(author)
    }
}
