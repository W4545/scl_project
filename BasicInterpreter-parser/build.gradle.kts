import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    id("org.jetbrains.kotlin.jvm") version "1.6.0"
}

dependencies {
    implementation(project(":BasicInterpreter-core"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val compileKotlin: KotlinCompile by tasks
val compileJava: JavaCompile by tasks

compileJava.destinationDirectory.set(compileKotlin.destinationDirectory)

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}

ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.parser"