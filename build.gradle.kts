plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.epages.restdocs-api-spec") version "0.18.4"
    id("org.flywaydb.flyway") version "11.0.1"
    kotlin("plugin.jpa") version "1.9.25"
}

extra["snippetsDir"] = file("build/generated-snippets")

group = "com.status"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//	implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    //OpenAPI Converter
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

    //flyway
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")

    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
//	testImplementation("org.springframework.security:spring-security-test")

    //OpenAPI Converter
    testImplementation("com.epages:restdocs-api-spec:0.18.4")
    testImplementation("com.epages:restdocs-api-spec-mockmvc:0.18.4")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")


}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.test {
    useJUnitPlatform()
    outputs.dir(project.extra["snippetsDir"]!!)
}

openapi3 {
    this.setServer("http://localhost:8080")
    this.title = "STATUS API"
    this.description = "STATUS API"
    this.version = "0.0.1"
    this.format = "yaml"
}

// OpenAPI 명세 파일 복사 작업 정의
tasks.register<Copy>("copyOpenApiDocs") {
    dependsOn("test")
    from(file("build/api-spec/openapi3.yaml"))
    into(file("src/main/resources/static/swagger-ui"))
    // 동일파일 존재 시 덮어쓰기
    DuplicatesStrategy.INCLUDE
}

// test 작업 후에 OpenAPI 명세 파일 복사 작업 실행
tasks.named("test") {
    finalizedBy("copyOpenApiDocs")
}

