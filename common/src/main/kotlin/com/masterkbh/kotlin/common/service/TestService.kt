package com.masterkbh.kotlin.common.service

import com.masterkbh.kotlin.common.component.mapper.TestEntityMapper
import com.masterkbh.kotlin.common.dto.TestEntityDTO
import com.masterkbh.kotlin.common.dto.TestEntityRegistration
import com.masterkbh.kotlin.common.entity.TestEntity
import com.masterkbh.kotlin.common.repository.TestRepository
import io.github.serpro69.kfaker.Faker
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDateTime

@Service
class TestService(
    val testRepository: TestRepository
) {
    fun testMethod(): String {
        return testRepository.count().toString()
    }

    fun addTestEntity(num: Int) {
        val faker = Faker()

        for (i in 0..num) {
            val testEntity = TestEntityRegistration(
                "결혼 했느냐",
                "김보훈",
                "코틀린마스터",
                "시흥동",
                BigDecimal.valueOf(faker.money.amount().toLong())
            ).toEntity()

            testRepository.save(testEntity)
        }
    }

    fun callQueryDSL(): List<TestEntity> {
        return testRepository.findByIdAndUpdateAt(1, LocalDateTime.now())
    }

    fun findAll(): List<TestEntityDTO> {
        return Mappers.getMapper(TestEntityMapper::class.java)
            .toDTOList(testRepository.findAll())
    }
}