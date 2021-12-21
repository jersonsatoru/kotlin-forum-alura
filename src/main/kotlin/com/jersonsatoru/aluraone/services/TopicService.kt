package com.jersonsatoru.aluraone.services

import org.springframework.stereotype.Service
import com.jersonsatoru.aluraone.entities.Topic
import com.jersonsatoru.aluraone.dtos.CreateTopicInput
import com.jersonsatoru.aluraone.repositories.TopicRepository
import com.jersonsatoru.aluraone.mappers.CreateTopicInputToTopicMapper
import java.time.LocalDateTime

@Service
class TopicService(
    private val topicRepository: TopicRepository,
    private val createTopicInputToTopicMapper: CreateTopicInputToTopicMapper
    ) {


    fun getAll(): List<Topic> {
        return this.topicRepository.findAll();
    }

    fun findById(id: Long): Topic? {
        return this.topicRepository.findById(id)
    }

    fun save(createTopicInput: CreateTopicInput): Topic {
        val topic = this.createTopicInputToTopicMapper.map(createTopicInput)
        val createdTopic = this.topicRepository.save(topic)
        return createdTopic
    }
}