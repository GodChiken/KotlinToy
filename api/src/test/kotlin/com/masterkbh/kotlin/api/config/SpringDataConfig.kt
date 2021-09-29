package com.masterkbh.kotlin.api.config

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.extensions.Extension
import io.kotest.spring.SpringAutowireConstructorExtension
import io.kotest.spring.SpringListener
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.TestPropertySource
import org.testcontainers.containers.JdbcDatabaseContainer
import org.testcontainers.containers.MariaDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = ["com/masterkbh/kotlin/resources/application-test.yml"])
@EntityScan(basePackages = ["com.masterkbh.kotlin.common.entity"])
@EnableJpaRepositories(basePackages = ["com.masterkbh.kotlin.common.repository"])
@Testcontainers
class SpringDataConfig : AbstractProjectConfig() {
    override fun listeners() = listOf(SpringListener)
    override fun extensions(): List<Extension> = listOf(SpringAutowireConstructorExtension)
    /*@Container
    var mariaDB: MariaDBContainer = MariaDBContainer("mariadb:10.5") // 이미지
        .withUsername("myuser") // DB 사용자
        .withPassword("mypassword") // 암호
        .withDatabaseName("mydb") // 사용할 데이터베이스
        .withInitScript("init.sql") // 초기 실행 쿼리

    private val mysqlContainer = MariaDBContainer(image = "mysql:8.0.22")
        .withDatabaseName("myapp")*/

}