package com.jersonsatoru.aluraone.repositories

import javax.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository class ComplexTopicRepository(val em: EntityManager) {}
