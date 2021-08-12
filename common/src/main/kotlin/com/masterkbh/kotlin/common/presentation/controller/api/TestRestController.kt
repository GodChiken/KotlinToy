package com.masterkbh.kotlin.common.presentation.controller.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestRestController {

    @GetMapping("/test")
    fun test(): String = "asdf"

    @GetMapping
    fun cou(): String = "a"
}