package com.jersonsatoru.aluraone.repositories

import com.jersonsatoru.aluraone.entities.Answer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository interface AnswerRepository : JpaRepository<Answer, Long>
