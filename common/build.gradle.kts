tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = false
}

tasks.getByName<Jar>("jar") {
    enabled = true
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
tasks.test {
    useJUnitPlatform()
}
dependencies {
    //kotlin-reflect은 Kotlin 리플렉션 라이브러리입니다 (Spring Framework 5에서 필수).
    api(kotlin("reflect"))
    //kotlin-stdlib-jdk8은 Kotlin 표준 라이브러리의 Java 8 변형입니다.
    api(kotlin("stdlib-jdk8"))
    //spring boot dependency
    api("org.springframework.boot:spring-boot-starter")
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.boot:spring-boot-starter-mustache")
    //kotlin coroutine 사용시필수
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    //kolin reactive programming
    api("io.reactivex.rxjava2:rxkotlin:2.4.0")
    //파일형식의 json 파싱
    api("com.google.code.gson:gson:2.8.5")
    //mariaDB
    implementation("org.mariadb.jdbc:mariadb-java-client:2.7.3")
    runtimeOnly("mysql:mysql-connector-java")

    //Entity <-> DTO Mapper
    implementation("org.mapstruct:mapstruct:1.4.2.Final")
    kapt("org.mapstruct:mapstruct-processor:1.4.2.Final")

    api("com.querydsl:querydsl-jpa")
    kapt("com.querydsl:querydsl-apt:4.4.0:jpa")
    kapt("org.springframework.boot:spring-boot-configuration-processor")
    sourceSets{
        main{
            java {
                srcDir("$buildDir/generated/source/kapt/main")
            }
        }
    }
}