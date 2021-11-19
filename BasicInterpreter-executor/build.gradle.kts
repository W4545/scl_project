import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    id("org.jetbrains.kotlin.jvm") version "1.6.0"
}

dependencies {
    implementation(project(":BasicInterpreter-core"))
    implementation(project(":BasicInterpreter-parser"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val compileKotlin: KotlinCompile by tasks
val compileJava: JavaCompile by tasks

compileKotlin.destinationDirectory.set(compileJava.destinationDirectory)

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}

ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.executor"