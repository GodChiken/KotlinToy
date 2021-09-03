package com.masterkbh.kotlin.common.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class TestEntityDTO(
    var id       : Long,
    var createdAt : LocalDateTime,
    var updatedAt : LocalDateTime?,
    var secret   : String?,
    var name     : String?,
    var nickName : String?,
    var address  : String?,
    var money    : BigDecimal
)