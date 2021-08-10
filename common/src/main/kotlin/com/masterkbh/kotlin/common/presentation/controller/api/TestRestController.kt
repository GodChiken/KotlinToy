package com.masterkbh.kotlin.common.presentation.controller.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestRestController {

    @GetMapping("/")
    fun index(): String ="Hello Index"
    @GetMapping("/test")
    fun test(): String = "asdf"
}