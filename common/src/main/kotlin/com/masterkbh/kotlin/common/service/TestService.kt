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

    fun addTestEntity(num: Int): Int {
        val faker = Faker()

        for (i in 0..num) {
            val testEntity = TestEntityRegistration(
                faker.animal.name(),
                "김보훈",
                faker.funnyName.name(),
                faker.address.fullAddress(),
                BigDecimal.valueOf(3000000L)
            ).toEntity()

            testRepository.save(testEntity)
        }
        return testRepository.findAll().count()
    }

    fun callQueryDSL(): List<TestEntity> {
        return testRepository.findByIdAndUpdateAt(1, LocalDateTime.now())
    }

    fun findAll(): List<TestEntityDTO> {
        return Mappers.getMapper(TestEntityMapper::class.java)
            .toDTOList(testRepository.findAll())
    }

    fun addTestEntity(testEntityRegistration: TestEntityRegistration) : TestEntityDTO{
        val testEntity = testEntityRegistration.toEntity()
        testRepository.save(testEntity)
        return Mappers.getMapper(TestEntityMapper::class.java).toDTO(testEntity)
    }
}