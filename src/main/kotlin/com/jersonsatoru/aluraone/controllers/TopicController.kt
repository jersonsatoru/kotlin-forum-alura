package com.jersonsatoru.aluraone.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import com.jersonsatoru.aluraone.entities.Topic
import com.jersonsatoru.aluraone.services.TopicService
import com.jersonsatoru.aluraone.dtos.CreateTopicInput
import java.time.LocalDateTime
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/topics")
class TopicController (private val topicService: TopicService){

    @GetMapping()
    fun index(): List<Topic> {
        return topicService.getAll()
    }

    @GetMapping("{id}")
    fun getBy(@PathVariable() id: Long): Topic {
        return topicService.findById(id) ?: throw Exception("Topic not found")
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun store(@RequestBody() @Valid createTopicInput: CreateTopicInput): Topic {
        return topicService.save(createTopicInput);
    }
}
