package com.jersonsatoru.aluraone.entities

import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class Topic(
    val id: Long?,
    val title: String,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val anwsers: List<Answer> = listOf()
)
