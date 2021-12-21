package com.jersonsatoru.aluraone.entities

import java.time.LocalDateTime

data class Answer (
    val id: Long?,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: Author,
    val solved: Boolean,
    val topic: Topic,
)
