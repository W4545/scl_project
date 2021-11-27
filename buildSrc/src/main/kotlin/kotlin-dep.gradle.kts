import org.gradle.kotlin.dsl.`java-library`

plugins {
    `java-library`
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = Versions.JAVA_VERSION
    targetCompatibility = Versions.JAVA_VERSION
}

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
val compileJava: JavaCompile by tasks

compileJava.destinationDirectory.set(compileKotlin.destinationDirectory)

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = Versions.JAVA_VERSION.majorVersion
    }
}