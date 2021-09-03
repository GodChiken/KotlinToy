package com.masterkbh.kotlin.api.router

import com.masterkbh.kotlin.common.service.TestService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class APITestController (
    val testService: TestService
){
    @GetMapping("/add/{num}")
    fun addDummy(@PathVariable num:Int){
        testService.addTestEntity(num)
    }
}