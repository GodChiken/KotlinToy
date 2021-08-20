package com.masterkbh.kotlin.common.component.mapper

import com.masterkbh.kotlin.common.dto.TestEntityDTO
import com.masterkbh.kotlin.common.entity.TestEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface TestEntityMapper {

    fun toDTO(testEntity: TestEntity) : TestEntityDTO
    fun toEntity(testEntityDTO: TestEntityDTO) : TestEntity

}