plugins {
    id("com.netflix.dgs.codegen") version "5.0.6"
}

dependencies {
    implementation(project(":common"))
    implementation(platform("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:4.7.3"))
    implementation("com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter")
    implementation("com.netflix.graphql.dgs:graphql-dgs-extended-scalars")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-joda")
}

tasks.withType<com.netflix.graphql.dgs.codegen.gradle.GenerateJavaTask> {
    packageName = "com.masterkbh.kotlin.generated"
    typeMapping = mutableMapOf(
        "BigDecimal" to "java.math.BigDecimal",
        "Long" to "kotlin.Long"
    )
}