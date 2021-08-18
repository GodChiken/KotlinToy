package com.masterkbh.kotlin.common.repository.custom

import com.masterkbh.kotlin.common.entity.TestEntity
import java.time.LocalDate

interface CustomTestEntityRepository {
    fun findByIdAndUpdateAt(id:Long, localDate:LocalDate ) : List<TestEntity>
}