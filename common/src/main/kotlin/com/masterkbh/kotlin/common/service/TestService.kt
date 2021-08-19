package com.masterkbh.kotlin.common.service

import com.masterkbh.kotlin.common.entity.TestEntity
import com.masterkbh.kotlin.common.repository.TestRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class TestService (
    private val testRepository: TestRepository
){
    fun testMethod(): String {
        return testRepository.count().toString();
    }

    fun addTestEntity() {
        val testEntity = TestEntity()
        testEntity.insertedAt = LocalDate.now()
        testEntity.updatedAt = LocalDate.now().plusDays(1)
        testRepository.save(testEntity);
    }

    fun transactionTest() {
        val testEntity = TestEntity()
        testEntity.insertedAt = LocalDate.now()
        testEntity.updatedAt = LocalDate.now().plusDays(2)
        testRepository.save(testEntity)
        throw RuntimeException()
    }

    @Transactional
    fun transactionTest2() {
        val testEntity = TestEntity()
        testEntity.insertedAt = LocalDate.now()
        testEntity.updatedAt = LocalDate.now().plusDays(2)
        testRepository.save(testEntity);
        throw RuntimeException()
    }

    fun callQueryDSL(): List<TestEntity> {
        return testRepository.findByIdAndUpdateAt(1, LocalDate.now())
    }
}