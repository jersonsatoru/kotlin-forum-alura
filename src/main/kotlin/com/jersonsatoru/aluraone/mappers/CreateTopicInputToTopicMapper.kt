package com.jersonsatoru.aluraone.mappers

import com.jersonsatoru.aluraone.dtos.CreateTopicInput
import com.jersonsatoru.aluraone.entities.Topic
import java.time.LocalDateTime
import org.springframework.stereotype.Component

@Component
class CreateTopicInputToTopicMapper : Mapper<CreateTopicInput, Topic> {
    override fun map(t: CreateTopicInput): Topic = Topic(
        null,
        t.title,
        t.message,
        LocalDateTime.now()
    )
}