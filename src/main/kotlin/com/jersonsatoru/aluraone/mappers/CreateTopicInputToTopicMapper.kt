package com.jersonsatoru.aluraone.mappers

import com.jersonsatoru.aluraone.dtos.CreateTopicInput
import com.jersonsatoru.aluraone.entities.Author
import com.jersonsatoru.aluraone.entities.Course
import com.jersonsatoru.aluraone.entities.Topic
import java.time.LocalDateTime
import org.springframework.stereotype.Component

@Component
class CreateTopicInputToTopicMapper : Mapper<CreateTopicInput, Topic> {
    override fun map(t: CreateTopicInput): Topic =
            Topic(
                    null,
                    title = t.title,
                    message = t.message,
                    createdAt = LocalDateTime.now(),
                    course = Course(t.courseId, "", ""),
                    author = Author(t.authorId, "", "", ""),
            )
}
