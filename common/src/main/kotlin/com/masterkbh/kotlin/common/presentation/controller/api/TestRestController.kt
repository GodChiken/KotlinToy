package com.masterkbh.kotlin.common.presentation.controller.api

import com.masterkbh.kotlin.common.dto.TestEntityDTO
import com.masterkbh.kotlin.common.service.TestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestRestController(
    private val testService: TestService
) {

    @GetMapping("/test")
    fun test(): String = testService.testMethod()

    @GetMapping("/add")
    fun insert() {
        testService.addTestEntity(100)
    }

    @GetMapping("/call/query_dsl")
    fun callQueryDSL() {
        testService.callQueryDSL()
    }

    @GetMapping("/find-all")
    fun findAll(): List<TestEntityDTO> {
        return testService.findAll()
    }
}