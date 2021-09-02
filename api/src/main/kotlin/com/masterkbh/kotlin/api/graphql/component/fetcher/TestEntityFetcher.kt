package com.masterkbh.kotlin.api.graphql.component.fetcher

import com.masterkbh.kotlin.common.dto.TestEntityDTO
import com.masterkbh.kotlin.common.service.TestService
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class TestEntityFetcher(
    val testService: TestService
) {
    @DgsQuery
    fun testList(@InputArgument idFilter: Long?): List<TestEntityDTO> {
        return if (idFilter != null) {
            testService.findAll().filter { e -> e.id == idFilter }
        } else {
            testService.findAll()
        }
    }
}