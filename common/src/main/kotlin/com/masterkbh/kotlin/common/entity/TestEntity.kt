package com.masterkbh.kotlin.common.entity

import java.time.LocalDate
import javax.persistence.*

/*JPA Entity의 패키지 추후, Nexus를 통한 분리 필요*/
@Entity
@Table(name = "test_entity")
data class TestEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "secret")
    var secret: String? = null,

    //https://yangbox.tistory.com/24
    @Column(name = "inserted_at")
    var insertedAt: LocalDate? = LocalDate.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDate? = LocalDate.now()

)