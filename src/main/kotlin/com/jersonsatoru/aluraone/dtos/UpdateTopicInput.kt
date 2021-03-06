package com.jersonsatoru.aluraone.dtos

import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class UpdateTopicInput(
        val id: Long,
        @field:NotEmpty() @field:Size(min = 5, max = 200) val title: String,
        @field:NotEmpty() @field:Size(min = 5, max = 200) val message: String,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val authorId: Long,
        val courseId: Long,
)
