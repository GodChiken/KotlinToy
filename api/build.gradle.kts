plugins {
    id("com.netflix.dgs.codegen") version "5.0.6"
}

dependencies {
    implementation(project(":common"))
    implementation(platform("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:4.7.3"))
    implementation("com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter")
    implementation("com.netflix.graphql.dgs:graphql-dgs-extended-scalars")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-joda")
    //test container
    testImplementation("org.testcontainers:testcontainers:1.16.0")
    testImplementation("org.testcontainers:junit-jupiter:1.16.0")
    testImplementation("org.testcontainers:mariadb:1.16.0")
}

/**
 * 확장 스칼라 타입을 쓰는 경우 반드시 타입매핑을 그레이들 테스크에 추가해야한다.
 * https://github.com/Netflix/dgs-framework/discussions/601
 * Long Type 은 오류가 있어서 직접 매핑해줘야 원활하게 작동한다.
 * 자동으로 처리되지 않는 이유는 Client에서 Long타입은 원활하게 작동하는 타입이 아니기 때문에
 * netflix dgs에서 별도로 처리하지 않았기 때문이다.
 */
tasks.withType<com.netflix.graphql.dgs.codegen.gradle.GenerateJavaTask> {
    packageName = "com.masterkbh.kotlin.generated"
    typeMapping = mutableMapOf(
        "BigDecimal" to "java.math.BigDecimal",
        "Long" to "kotlin.Long"
    )
}