package com.masterkbh.kotlin.common.repository.custom.impl

import com.masterkbh.kotlin.common.entity.QTestEntity.testEntity
import com.masterkbh.kotlin.common.entity.TestEntity
import com.masterkbh.kotlin.common.repository.custom.CustomTestEntityRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import java.time.LocalDateTime

class CustomTestEntityRepositoryImpl : QuerydslRepositorySupport(TestEntity::class.java), CustomTestEntityRepository {
    override fun findByIdAndUpdateAt(id: Long, updateAt: LocalDateTime): List<TestEntity> {
        return from(testEntity)
            .where(testEntity.updatedAt.eq(updateAt))
            .where(testEntity.id.eq(id))
            .fetch()
    }
}