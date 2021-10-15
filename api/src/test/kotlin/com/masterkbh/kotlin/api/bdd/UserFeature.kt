package com.masterkbh.kotlin.api.bdd

import com.masterkbh.kotlin.api.config.SpringDataConfig
import com.masterkbh.kotlin.common.repository.TestRepository
import com.masterkbh.kotlin.common.service.TestService
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.IsolationMode.InstancePerLeaf
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration


@ContextConfiguration(classes = [SpringDataConfig::class])
//@ActiveProfiles(profiles = ["dev"])
//@ActiveProfiles(profiles = ["prod"])
//@ActiveProfiles(profiles = ["test-in-memory-DB"])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles(profiles = ["test-DB"])
class UserFeature(
    testRepository: TestRepository
) : BehaviorSpec() {

    private val mockTestService = mockk<TestService>()
    private val mockTestRepository = spyk(testRepository)

    //https://kotest.io/docs/framework/isolation-mode.html
    override fun isolationMode(): IsolationMode = InstancePerLeaf

    init {
        Given("불특정 요청자가 나의 제공 서비스중") {
            val userName = "불특정"
            When("100개의 테스트 엔티티 생성을 하고자 할때") {
                userName shouldBe "불특정"

                val addTestEntityAPI = "/add/"
                val addCount = 100
                val testAPI = addTestEntityAPI.plus(addCount)

                testAPI shouldBe "/add/100"
                And("테스트객체 추가 API를 요청하면") {
                    every { mockTestService.addTestEntity(ofType(Int::class)) } returns addCount
                    Then("테스트 객체가 추가된다.") {
                        mockTestService.addTestEntity(addCount) shouldBe 100
                    }
                }
            }
        }
    }
}

name: default
persistence provider classname: null
classloader: sun.misc.Launcher$AppClassLoader@73d16e93
excludeUnlistedClasses: true
JTA datasource: null
Non JTA datasource: org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory$EmbeddedDataSourceProxy@764125cc
Transaction type: RESOURCE_LOCAL
PU root URL: file:/Users/master/IdeaProjects/KotlinToy/common/build/libs/common-0.0.1-SNAPSHOT-plain.jar
Shared Cache Mode: UNSPECIFIED
Validation Mode: AUTO
Jar files URLs []
Managed classes names [
com.masterkbh.kotlin.common.entity.TestEntity
com.masterkbh.kotlin.common.entity.base.EntityId
com.masterkbh.kotlin.common.entity.base.TimeInfo
com.masterkbh.kotlin.common.entity.base.AuditingEntity]
Mapping files names []
Properties []