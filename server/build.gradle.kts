import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlin_version = "1.6.20"
    val spring_boot_version = "2.6.6"
    val spring_plugins_version = "1.0.11.RELEASE"
    val asciidoctor_version = "1.5.8"

    id("org.springframework.boot") version "$spring_boot_version"
    id("io.spring.dependency-management") version "$spring_plugins_version"
    id("org.asciidoctor.convert") version "$asciidoctor_version"
    kotlin("jvm") version "$kotlin_version"
    kotlin("plugin.spring") version "$kotlin_version"
    kotlin("plugin.jpa") version "$kotlin_version"
}

group = "kr.co.fish25"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["snippetsDir"] = file("build/generated-snippets")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.test {
    project.property("snippetsDir")?.let(inputs::dir)
}

tasks.asciidoctor {
    project.property("snippetsDir")?.let(inputs::dir)
    dependsOn(tasks.test)
}
