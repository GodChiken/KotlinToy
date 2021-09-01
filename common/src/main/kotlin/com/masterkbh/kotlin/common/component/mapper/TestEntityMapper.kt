package com.masterkbh.kotlin.common.component.mapper

import com.masterkbh.kotlin.common.dto.TestEntityDTO
import com.masterkbh.kotlin.common.entity.TestEntity
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper
interface TestEntityMapper {
    fun toDTO(testEntity: TestEntity) : TestEntityDTO
    @InheritInverseConfiguration
    fun toEntity(testEntityDTO: TestEntityDTO) : TestEntity

    fun toDTOList(testEntityList: List<TestEntity>) : List<TestEntityDTO>
    fun toEntityList(testEntityDTOList: List<TestEntityDTO>) : List<TestEntity>
}