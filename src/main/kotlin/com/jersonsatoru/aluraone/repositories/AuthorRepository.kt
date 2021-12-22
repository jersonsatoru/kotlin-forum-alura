package com.jersonsatoru.aluraone.repositories

import com.jersonsatoru.aluraone.entities.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository interface AuthorRepository : JpaRepository<Author, Long>
