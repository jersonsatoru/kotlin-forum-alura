package com.jersonsatoru.aluraone.repositories

import com.jersonsatoru.aluraone.entities.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository interface CourseRepository : JpaRepository<Course, Long>
