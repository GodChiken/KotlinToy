import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// 그레들 레퍼런스
// https://docs.gradle.org/current/dsl/org.gradle.api.Project.html#org.gradle.api.Project:artifacts(groovy.lang.Closure)


// https://notpeelbean.tistory.com/entry/gradle-buildscript-dependencies-%EC%99%80-dependencies-%EC%9D%98-%EC%B0%A8%EC%9D%B4
// 빌드 시 repository, depdency를 활용하여 참조하는 요소를 기술하는 곳, plugins{} 블럭에서 버전을 지정하면 그외의 곳에서 동일한 버전을 따라간다.
// 버전을 설정해야 하는 유일한 장소는 플러그인의 클래스 경로를 정의할 때 뿐이므로 본인은 삭제했다.
buildscript {
    /*전역변수를 설정하는 곳
    ext{

    }*/
    repositories { mavenCentral() }
    dependencies { classpath( "org.jetbrains.kotlin:kotlin-noarg") }
}

// https://plugins.gradle.org/ 위 사이트에서 플러그인 정보를 확인한다.
// https://stackoverflow.com/questions/47588311/gradle-kotlin-dsl-define-kotlin-version-in-unique-place 버전을 따로 관리하려고 시도해보면서 얻은 결론.
/**
 * 프로젝트를 빌드하기 위해서 여러가지 작업을 처리해 줘야 합니다. 컴파일이나 jar 파일의 생성 같은 작업들이죠.
 * 이런 작업들을 해주는 플러그인들이 존재합니다. plugins 블록 안에 필요한 플러그인을 지정해주고 이런 플로그인들은 필요한 과정들을 task로 포함하고 있습니다.
 * 빌드시에는 필요한 모든 과정을 플러그인의 내부 task가 진행해 주게 됩니다.
 * */
plugins {
    val kotlinVersion = "1.5.21"
    id("org.springframework.boot") version "2.5.3" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
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
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin( "kotlin-allopen")
    }
}

allOpen {
    annotation("javax.persistence.Entity")
}