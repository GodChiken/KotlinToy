package com.masterkbh.kotlin.common.repository.custom

import com.masterkbh.kotlin.common.entity.TestEntity
import java.time.LocalDateTime

interface CustomTestEntityRepository {
    fun findByIdAndUpdateAt(id: Long, updateAt: LocalDateTime): List<TestEntity>
}