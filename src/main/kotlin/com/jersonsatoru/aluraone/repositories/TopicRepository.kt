package com.jersonsatoru.aluraone.repositories

import com.jersonsatoru.aluraone.dtos.TopicReportDTO
import com.jersonsatoru.aluraone.entities.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository : JpaRepository<Topic, Long> {
    @EntityGraph(attributePaths = ["course", "author", "answers"])
    override fun findAll(page: Pageable): Page<Topic>

    @EntityGraph(attributePaths = ["course", "author", "answers"])
    fun findByCourseName(courseName: String, page: Pageable): Page<Topic>

    @Query(
            """
        SELECT 
            new com.jersonsatoru.aluraone.dtos.TopicReportDTO(course.name, count(t)) 
        FROM 
            Topic t JOIN 
            t.course course 
        GROUP BY 
            course.category
        """
    )
    fun getReport(): List<TopicReportDTO>
}
