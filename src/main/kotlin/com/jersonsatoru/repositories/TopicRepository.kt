package com.jersonsatoru.aluraone.repositories

import org.springframework.stereotype.Repository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import com.jersonsatoru.aluraone.entities.Topic
import java.time.LocalDateTime

@Component
class TopicRepository(private var topics: MutableList<Topic>) {
    init {
        val topic1 = Topic(
            1,
            "Doubt on spring boot with Kotlin",
            "What can I do it?",
            LocalDateTime.now(),
            listOf()
        )
        val topic2 = Topic(
            2,
            "Integer or Long",
            "How to implement this?",
            LocalDateTime.now().plusDays(15),
            listOf()
        )
        val topic3 = Topic(
            3,
            "Threads",
            "Is it possible to implement it?",
            LocalDateTime.now().minusDays(120),
            listOf()
        )
        this.topics = mutableListOf(topic1, topic2, topic3)
    }

    fun findAll(): List<Topic> {

        return this.topics;
    }

    fun findById(id: Long): Topic? {
        return this.topics.find { it.id == id }
    }

    fun save(pTopic: Topic): Topic {
        val topic = pTopic.copy(id = this.topics.size.toLong() + 1)
        this.topics.add(topic)
        return topic;
    }
}
