package com.masterkbh.kotlin.common.configuration

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Configuration
class QueryDSLConfiguration (@PersistenceContext val entityManager: EntityManager) {
    @Bean
    fun jpqQueryFactory() = JPAQueryFactory(entityManager)
}