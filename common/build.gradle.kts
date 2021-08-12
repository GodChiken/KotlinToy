tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = false
}

tasks.getByName<Jar>("jar") {
    enabled = true
    baseName = "common"
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
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
    //kotlin coroutine 사용시필수
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    //kolin reactive programming
    api("io.reactivex.rxjava2:rxkotlin:2.4.0")
    //파일형식의 json 파싱
    api("com.google.code.gson:gson:2.8.5")
    //mariaDB
    implementation("org.mariadb.jdbc:mariadb-java-client:2.7.3")
    runtimeOnly("mysql:mysql-connector-java")
    //test
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}