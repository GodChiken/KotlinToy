package com.masterkbh.kotlin.common.service

import com.masterkbh.kotlin.common.entity.TestEntity
import com.masterkbh.kotlin.common.repository.TestRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TestService (
    private val testRepository: TestRepository
){
    fun testMethod(): String {
        return "test5"
    }
    fun addTestEntity() {
        val testEntity = TestEntity()
        testEntity.insertedAt = LocalDate.now()
        testEntity.updatedAt = LocalDate.now().plusDays(1)
        testRepository.save(testEntity);
    }

    fun callQueryDSL(): List<TestEntity> {
        return testRepository.findByIdAndUpdateAt(1, LocalDate.now())
    }
}