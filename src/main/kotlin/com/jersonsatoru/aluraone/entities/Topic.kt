package com.jersonsatoru.aluraone.entities

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
data class Topic(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
        val title: String,
        val message: String,
        @ManyToOne val course: Course,
        @ManyToOne val author: Author,
        @OneToMany(mappedBy = "topic") val answers: List<Answer> = listOf(),
        val createdAt: LocalDateTime = LocalDateTime.now(),
        @Enumerated(value = EnumType.STRING) val status: StatusTopic = StatusTopic.NAO_RESPONDIDO,
)
