package com.masterkbh.kotlin.common

import io.kotlintest.specs.BehaviorSpec

/*
* Feature : 테스트에 대상의 기능/책임을 명시한다.
* Scenario : 테스트 목적에 대한 상황을 설명한다.
* Given : 시나리오 진행에 필요한 값을 설정한다.
* When : 시나리오를 진행하는데 필요한 조건을 명시한다.
* Then : 시나리오를 완료했을 때 보장해야 하는 결과를 명시한다
* */

class TestEntityTestByBDD : BehaviorSpec ({


    given("/add/test/transaction"){
        `when`("이 주소로 요청을 보내면"){
            then("트랜잭션이 정상작동한다."){
                println("asdf")
            }
        }
    }
})