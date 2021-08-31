package com.masterkbh.kotlin.api.config

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.extensions.Extension
import io.kotest.spring.SpringAutowireConstructorExtension
import io.kotest.spring.SpringListener
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@DataJpaTest
@EntityScan(basePackages = ["com.masterkbh.kotlin.common"])
@EnableJpaRepositories(basePackages = ["com.masterkbh.kotlin.common"])
class SpringDataConfig : AbstractProjectConfig() {
    override fun listeners() = listOf(SpringListener)
    override fun extensions(): List<Extension> = listOf(SpringAutowireConstructorExtension)
}