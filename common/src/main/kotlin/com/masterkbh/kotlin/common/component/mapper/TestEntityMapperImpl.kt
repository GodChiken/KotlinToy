package com.masterkbh.kotlin.common.component.mapper

import com.masterkbh.kotlin.common.dto.TestEntityDTO
import com.masterkbh.kotlin.common.entity.TestEntity


class TestEntityMapperImpl : TestEntityMapper {
    override fun toDTO(testEntity: TestEntity): TestEntityDTO {
        TODO("builder 방식으로")
    }

    override fun toEntity(testEntityDTO: TestEntityDTO): TestEntity {
        TODO("builder 방식으로")
    }
}