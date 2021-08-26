package com.masterkbh.kotlin.api.router

import com.masterkbh.kotlin.common.service.TestService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class APITestController (
    val testService: TestService
){
    @GetMapping("/another-module")
    fun test(){
        testService.addTestEntityByAPI()
    }
}