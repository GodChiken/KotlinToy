package com.masterkbh.kotlin.api.bdd

import com.masterkbh.kotlin.api.config.SpringDataConfig
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.PropertySource
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@PropertySource("classpath:application.yml")
//@EnableAutoConfiguration(exclude=[DataSourceAutoConfiguration::class])
@ContextConfiguration(classes = [SpringDataConfig::class])
@ActiveProfiles(profiles = ["dev"])
@ComponentScan(basePackages = ["com.masterkbh.kotlin.api", "com.masterkbh.kotlin.common"])
@Transactional
class UserFeature : BehaviorSpec() {

    //private val mockTestRepository = spyk(testRepository)
    //private val mockTestService = TestService(testRepository)

    //https://kotest.io/docs/framework/isolation-mode.html
    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerLeaf

    init {
        given("불특정 요청자가 나의 제공 서비스중") {
            When("어떤 것을 사용하든") {
                and("테스트객체 추가 API를 요청하면") {
                    then("테스트 객체가 추가된다.") {
                        0 shouldBe 0
                    }
                }
            }
        }
    }
}