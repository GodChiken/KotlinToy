package com.masterkbh.kotlin.common.component.mapper

import com.masterkbh.kotlin.common.dto.TestEntityDTO
import com.masterkbh.kotlin.common.entity.TestEntity
import org.mapstruct.Mapper

/**
 * 수동으로 entity <-> dto 매핑을 진행해야하는 경우
 * @Mappings 어노테이션을 활용해야한다.
 * */
@Mapper
interface TestEntityMapper {

    fun toDTO(testEntity: TestEntity) : TestEntityDTO

    fun toEntity(testEntityDTO: TestEntityDTO) : TestEntity

    fun toDTOList(testEntityList: List<TestEntity>) : List<TestEntityDTO>

    fun toEntityList(testEntityDTOList: List<TestEntityDTO>) : List<TestEntity>
}