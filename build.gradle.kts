import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// https://notpeelbean.tistory.com/entry/gradle-buildscript-dependencies-%EC%99%80-dependencies-%EC%9D%98-%EC%B0%A8%EC%9D%B4
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath( "org.jetbrains.kotlin:kotlin-noarg")
    }
}
// https://plugins.gradle.org/ 위 사이트에서 플러그인 정보를 확인한다.
plugins {
    id("org.springframework.boot") version "2.5.3" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.21"
    kotlin("plugin.spring") version "1.5.21"
    kotlin("plugin.jpa") version "1.5.21"
}
// 전체 프로젝트에 적용할 내용? 인거같은데 확인이 필요
// 기존 depth-1 에 존재하는 task가 옮겨졌다.
allprojects {

    group = "com.masterkbh.kotlin"
    version = "0.0.1-SNAPSHOT"

    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
        targetCompatibility = JavaVersion.VERSION_1_8.toString()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
// 각 서브 모듈에서? 의존성을 분리하기 위해 세팅하는듯 하다.
subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("kotlin")
        plugin("kotlin-spring")
        plugin("kotlin-jpa")
        plugin("idea")
        plugin("eclipse")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin( "kotlin-allopen")
    }
}

allOpen {
    annotation("javax.persistence.Entity")
}