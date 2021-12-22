package com.jersonsatoru.aluraone.controllers

import com.jersonsatoru.aluraone.dtos.CreateTopicInput
import com.jersonsatoru.aluraone.dtos.TopicReportDTO
import com.jersonsatoru.aluraone.dtos.UpdateTopicInput
import com.jersonsatoru.aluraone.entities.Topic
import com.jersonsatoru.aluraone.services.TopicService
import javax.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("api/v1/topics")
class TopicController(private val topicService: TopicService) {

    @GetMapping("/report")
    fun report(): List<TopicReportDTO> {
        return this.topicService.report()
    }

    @GetMapping()
    @Cacheable("topics")
    fun index(
            @RequestParam() courseName: String?,
            @PageableDefault(size = 5, sort = ["createdAt"], direction = Sort.Direction.DESC)
            page: Pageable
    ): Page<Topic> {
        return topicService.getAll(courseName, page)
    }

    @GetMapping("{id}")
    fun getBy(@PathVariable() id: Long): Topic {
        return topicService.findById(id)
    }

    @PostMapping()
    @CacheEvict(value = ["topics"], allEntries = true)
    @ResponseStatus(HttpStatus.CREATED)
    fun store(
            @RequestBody() @Valid createTopicInput: CreateTopicInput,
            uriBuilder: UriComponentsBuilder,
    ): ResponseEntity<Topic> {
        val createdTopic = topicService.save(createTopicInput)
        val uri = uriBuilder.path("/api/v1/topics/${createdTopic.id}").build().toUri()
        return ResponseEntity.created(uri).body(createdTopic)
    }

    @PutMapping("{id}")
    @CacheEvict(value = ["topics"], allEntries = true)
    fun update(
            @RequestBody() @Valid updateTopicInput: UpdateTopicInput,
            @PathVariable() id: Long,
    ): Topic {
        return topicService.update(updateTopicInput.copy(id = id))
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = ["topics"], allEntries = true)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable() id: Long) {
        return this.topicService.delete(id)
    }
}
