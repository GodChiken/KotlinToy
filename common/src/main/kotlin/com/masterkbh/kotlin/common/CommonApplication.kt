package com.masterkbh.kotlin.common

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class CommonApplication

fun main(args: Array<String>) {
    runApplication<CommonApplication>(*args)
}
