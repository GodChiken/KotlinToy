plugins{
    id("com.netflix.dgs.codegen") version "5.0.6"
}

dependencies{
    implementation(project(":common"))
    implementation(platform("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:4.7.0"))
    implementation("com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter")
    implementation("com.netflix.graphql.dgs:graphql-dgs-extended-scalars")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-joda")
}