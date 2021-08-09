package com.masterkbh.kotlin.common.entity

import java.time.ZonedDateTime
import javax.persistence.*

/*JPA Entity의 패키지 추후, Nexus를 통한 분리 필요*/
@Entity
@Table(name = "test_entity")
class TestEntity (

    @Id // 3
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "secret")
    var secret: String? = null,

        @Column(name = "inserted_at")
    var insertedAt: ZonedDateTime? = ZonedDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: ZonedDateTime? = ZonedDateTime.now()
)