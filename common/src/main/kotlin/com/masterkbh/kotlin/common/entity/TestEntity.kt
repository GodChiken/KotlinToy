package com.masterkbh.kotlin.common.entity

import com.masterkbh.kotlin.common.entity.base.AuditingEntity
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.EntityListeners

/*JPA Entity의 패키지 추후, Nexus를 통한 분리 필요*/
@Entity
@EntityListeners(AuditingEntityListener::class)
data class TestEntity(
    var secret: String?,
    var name: String?,
    var nickName: String?,
    var address: String?,
    var money: BigDecimal?
) : AuditingEntity()