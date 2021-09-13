package com.masterkbh.kotlin.api.bdd

import com.masterkbh.kotlin.api.config.SpringDataConfig
import com.masterkbh.kotlin.common.repository.TestRepository
import com.masterkbh.kotlin.common.service.TestService
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration


@ContextConfiguration(classes = [SpringDataConfig::class])
@ActiveProfiles(profiles = ["dev"])
@ComponentScan(basePackages = ["com.masterkbh.kotlin.api", "com.masterkbh.kotlin.common"])
class UserFeature : BehaviorSpec() {

    private val mockTestService = mockk<TestService>()
    private val mockTestRepository = mockk<TestRepository>()

    //https://kotest.io/docs/framework/isolation-mode.html
    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerLeaf

    init {
        given("불특정 요청자가 나의 제공 서비스중"){
            When("어떤 것을 사용하든"){
                and("테스트객체 추가 API를 요청하면"){
                    then("테스트 객체가 추가된다."){
                        0 shouldBe 0
                    }
                }
            }
        }
    }
}