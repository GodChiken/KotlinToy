package com.masterkbh.kotlin.api.graphql.component.mutation

import com.masterkbh.kotlin.common.dto.TestEntityDTO
import com.masterkbh.kotlin.common.dto.TestEntityRegistration
import com.masterkbh.kotlin.common.service.TestService
import com.masterkbh.kotlin.generated.DgsConstants
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument


/**
 *
 *
 *
 * */

@DgsComponent
class TestEntityMutation(
    val testService: TestService
) {
    @DgsData(parentType = DgsConstants.Mutation_TYPE, field = DgsConstants.MUTATION.InsertTestEntity)
    fun insertTestEntity(
        @InputArgument("registration") testEntityRegistration: TestEntityRegistration
    ): TestEntityDTO {
        return testService.addTestEntity(testEntityRegistration)
    }
}