package com.jersonsatoru.aluraone.services

import com.jersonsatoru.aluraone.dtos.CreateTopicInput
import com.jersonsatoru.aluraone.dtos.TopicReportDTO
import com.jersonsatoru.aluraone.dtos.UpdateTopicInput
import com.jersonsatoru.aluraone.entities.Topic
import com.jersonsatoru.aluraone.exceptions.NotFoundException
import com.jersonsatoru.aluraone.mappers.CreateTopicInputToTopicMapper
import com.jersonsatoru.aluraone.mappers.UpdateTopicInputToTopicMapper
import com.jersonsatoru.aluraone.repositories.TopicRepository
import javax.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicService(
        private val topicRepository: TopicRepository,
        private val createTopicInputToTopicMapper: CreateTopicInputToTopicMapper,
        private val updateTopicInputToTopicMapper: UpdateTopicInputToTopicMapper
) {

    fun getAll(courseName: String?, page: Pageable): Page<Topic> {
        return if (courseName.isNullOrEmpty()) {
            this.topicRepository.findAll(page)
        } else {
            this.topicRepository.findByCourseName(courseName, page)
        }
    }

    fun findById(id: Long): Topic {
        return this.topicRepository.findById(id).orElseThrow {
            NotFoundException("Topic not found")
        }
    }

    @Transactional()
    fun save(createTopicInput: CreateTopicInput): Topic {
        val topic = this.createTopicInputToTopicMapper.map(createTopicInput)
        val createdTopic = this.topicRepository.save(topic)
        return createdTopic
    }

    @Transactional()
    fun update(updateTopicInput: UpdateTopicInput): Topic {
        val topic = this.updateTopicInputToTopicMapper.map(updateTopicInput)
        this.topicRepository.save(topic)
        return topic
    }

    @Transactional()
    fun delete(id: Long) {
        val topic =
                topicRepository.findById(id).orElseThrow { NotFoundException("Topic not found") }
        this.topicRepository.delete(topic)
    }

    fun report(): List<TopicReportDTO> {
        return this.topicRepository.getReport()
    }
}
