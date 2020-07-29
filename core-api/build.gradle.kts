import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

dependencies {

}

tasks.getByName<BootJar>("bootJar"){
    enabled = false
}

tasks.getByName<Jar>("jar"){
    enabled = true
}