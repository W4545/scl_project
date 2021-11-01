import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    id("org.jetbrains.kotlin.jvm") version "1.5.31"
}

dependencies {
    implementation(project(":BasicInterpreter-core"))
    implementation(project(":BasicInterpreter-scanner"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val compileKotlin: KotlinCompile by tasks
val compileJava: JavaCompile by tasks

compileJava.destinationDirectory.set(compileKotlin.destinationDirectory)

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
}

ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.parser"