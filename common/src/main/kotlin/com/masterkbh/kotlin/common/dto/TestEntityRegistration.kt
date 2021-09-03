package com.masterkbh.kotlin.common.dto

import com.masterkbh.kotlin.common.entity.TestEntity
import java.math.BigDecimal
import java.time.LocalDateTime

data class TestEntityRegistration(
    var secret: String?,
    var name: String?,
    var nickName: String?,
    var address: String?,
    var money    : BigDecimal
) {
    fun toEntity() = TestEntity(
        secret,
        name,
        nickName,
        address,
        money
    )
}