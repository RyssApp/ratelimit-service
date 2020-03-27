plugins {
    java
    kotlin("jvm") version "1.3.71"
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

group = "app.ryss"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // Logging
    implementation("org.slf4j", "slf4j-api", "2.0.0-alpha1")
    implementation("ch.qos.logback", "logback-classic", "1.3.0-alpha5")
    implementation("io.github.microutils", "kotlin-logging", "1.7.9")

    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    jar {
        archiveClassifier.value = "original"
    }

    shadowJar {
        archiveFileName.value = "gateway-service.jar"
    }
}

/**
 * Represents the mutable value of a [Property].
 */
var <T> Property<T>.value: T?
    get() = orNull
    set(value) = set(value)