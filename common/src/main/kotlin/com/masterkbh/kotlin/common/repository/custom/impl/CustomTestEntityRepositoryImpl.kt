package com.masterkbh.kotlin.common.repository.custom.impl

import com.masterkbh.kotlin.common.entity.QTestEntity.testEntity
import com.masterkbh.kotlin.common.entity.TestEntity
import com.masterkbh.kotlin.common.repository.custom.CustomTestEntityRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import java.time.LocalDate

class CustomTestEntityRepositoryImpl : QuerydslRepositorySupport(TestEntity::class.java), CustomTestEntityRepository {
    override fun findByIdAndUpdateAt(id: Long, localDate: LocalDate): List<TestEntity> {
        return from(testEntity)
            .where(testEntity.updatedAt.eq(localDate))
            .where(testEntity.id.eq(id))
            .fetch()
    }
}