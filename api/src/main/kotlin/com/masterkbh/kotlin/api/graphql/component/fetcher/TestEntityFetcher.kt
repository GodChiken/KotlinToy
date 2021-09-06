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
    fun testList(
        @InputArgument idFilter: Long?,
        @InputArgument secretContain: String?,
        @InputArgument nameContain: String?,
        @InputArgument nickNameContain: String?,
        @InputArgument addressContain: String?
    ): List<TestEntityDTO> {
        val testList = testService.findAll()
        getIDFilteredList(idFilter, testList)
        getSecretContainContainFilteredList(secretContain, testList)
        getNameContainFilteredList(nameContain, testList)
        getNickNameContainContainFilteredList(nickNameContain, testList)
        getAddressContainFilteredList(addressContain, testList)
        return testList
    }

    private fun getIDFilteredList(
        idFilter: Long?,
        testList: List<TestEntityDTO>
    ) = if (idFilter != null) {
        testList.filter { e -> e.id == idFilter }
    } else {
        testList
    }

    private fun getSecretContainContainFilteredList(
        secretContain: String?,
        testList: List<TestEntityDTO>
    ) = if (secretContain != null) {
        testList.filter { e -> e.secret?.contains(secretContain) ?: throw IllegalArgumentException("값을 적으세요") }
    } else {
        testList
    }

    private fun getNameContainFilteredList(
        nameContain: String?,
        testList: List<TestEntityDTO>
    ) = if (nameContain != null) {
        testList.filter { e -> e.name?.contains(nameContain) ?: throw IllegalArgumentException("값을 적으세요") }
    } else {
        testList
    }

    private fun getNickNameContainContainFilteredList(
        nickNameContain: String?,
        testList: List<TestEntityDTO>
    ) = if (nickNameContain != null) {
        testList.filter { e -> e.nickName?.contains(nickNameContain) ?: throw IllegalArgumentException("값을 적으세요") }
    } else {
        testList
    }

    private fun getAddressContainFilteredList(
        addressContain: String?,
        testList: List<TestEntityDTO>
    ) = if (addressContain != null) {
        testList.filter { e -> e.address?.contains(addressContain) ?: throw IllegalArgumentException("값을 적으세요") }
    } else {
        testList
    }

}