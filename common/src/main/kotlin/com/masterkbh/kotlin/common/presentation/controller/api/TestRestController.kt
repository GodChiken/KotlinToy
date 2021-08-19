package com.masterkbh.kotlin.common.presentation.controller.api

import com.masterkbh.kotlin.common.entity.TestEntity
import com.masterkbh.kotlin.common.service.TestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestRestController (
    private val testService: TestService
) {

    @GetMapping("/test")
    fun test(): String = testService.testMethod()

    @GetMapping("/add")
    fun insert(){
        testService.addTestEntity()
    }

    @GetMapping("/add/test/transaction")
    fun transactionTest(){
        testService.transactionTest()
    }

    @GetMapping("/add/test/transaction2")
    fun transactionTest2(){
        testService.transactionTest2()
    }

    @GetMapping("/call/query_dsl")
    fun callQueryDSL(): String {
        val testEntityList : List<TestEntity> =  testService.callQueryDSL()
        return "1"
    }
}