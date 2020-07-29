plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    kotlin("kapt")
}

dependencies {
    implementation(project(":core-api"))

    // ---------------- spring dependencies ---------------------------
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    // spring cloud dependencies
    implementation("org.springframework.cloud:spring-cloud-starter-consul-discovery")
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
    // spring configurations dependencies
    kapt("org.springframework.boot:spring-boot-configuration-processor")
    // graphql
    implementation("com.expediagroup:graphql-kotlin-spring-server:3.4.1")

    // ---------------- datasource dependencies ---------------------------
    runtimeOnly("mysql:mysql-connector-java")

    // ---------------- map-struct dependencies ---------------------------
    implementation("org.mapstruct:mapstruct:1.3.1.Final")
    implementation("com.github.pozo:mapstruct-kotlin:1.3.1.2")
    kapt("org.mapstruct:mapstruct-processor:1.3.1.Final")
    kapt("com.github.pozo:mapstruct-kotlin-processor:1.3.1.2")
    //


    // spring test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("io.projectreactor:reactor-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}
