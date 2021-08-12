package com.masterkbh.kotlin.common.presentation.controller.common

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/* */
@Controller
class TestController {
    @GetMapping("")
    fun index(): String ="Hello Index"
}