package com.masterkbh.kotlintoy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinToyApplication

fun main(args: Array<String>) {
    runApplication<KotlinToyApplication>(*args)
}
