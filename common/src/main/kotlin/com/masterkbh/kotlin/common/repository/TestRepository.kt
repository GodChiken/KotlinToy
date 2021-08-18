package com.masterkbh.kotlin.common.repository


import com.masterkbh.kotlin.common.entity.TestEntity
import com.masterkbh.kotlin.common.repository.custom.CustomTestEntityRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepository : JpaRepository<TestEntity,Long>, CustomTestEntityRepository {
}