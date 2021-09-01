package com.masterkbh.kotlin.api.graphql.component.fetcher

import com.masterkbh.kotlin.api.graphql.component.ShowsDataFetcher
import com.masterkbh.kotlin.common.dto.TestEntityDTO
import com.masterkbh.kotlin.common.service.TestService
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class TestEntityFetcher(
    val testService: TestService
) {
    @DgsData(parentType = "Query", field = "test")
    fun testData(): List<TestEntityDTO> {
        return testService.findAll()
    }
}