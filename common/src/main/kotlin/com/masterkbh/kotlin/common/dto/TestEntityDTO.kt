package com.masterkbh.kotlin.common.dto

import java.time.LocalDate

data class TestEntityDTO(
    var id: Long,
    var insertedAt: LocalDate?,
    var updatedAt: LocalDate?
)