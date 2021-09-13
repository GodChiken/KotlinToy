package com.masterkbh.kotlin.api.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.extensions.Extension
import io.kotest.spring.SpringAutowireConstructorExtension
import io.kotest.spring.SpringListener
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.PropertySource
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.sql.DataSource


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@PropertySource("classpath:application.yml")
@EntityScan(basePackages = ["com.masterkbh.kotlin.common.entity"])
@EnableJpaRepositories(basePackages = ["com.masterkbh.kotlin.common.repository"])
class SpringDataConfig : AbstractProjectConfig() {
    override fun listeners() = listOf(SpringListener)
    override fun extensions(): List<Extension> = listOf(SpringAutowireConstructorExtension)
}