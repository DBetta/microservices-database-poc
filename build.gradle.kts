import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.1.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.9.RELEASE" apply false
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72" apply false
    kotlin("plugin.jpa") version "1.3.72" apply false
    kotlin("kapt") version "1.3.72" apply false
}

extra["springCloudVersion"] = "Hoxton.SR6"

allprojects {
    group = "com.turnkey.poc"
    version = "0.0.1-SNAPSHOT"

    apply<IdeaPlugin>()
    apply<EclipsePlugin>()

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=compatibility")
            jvmTarget = "1.8"
        }
    }

    repositories {
        mavenCentral()
        jcenter()
    }
}

subprojects {
    apply<JavaPlugin>()
    apply<IdeaPlugin>()

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")


        implementation("org.apache.commons:commons-lang3")

        implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

        implementation("org.axonframework:axon-spring-boot-starter:4.3.5")

        // If not already on your classpath, you might need the jetbrains annotations
        compileOnly("org.jetbrains:annotations")
        testCompileOnly("org.jetbrains:annotations")
    }

}
