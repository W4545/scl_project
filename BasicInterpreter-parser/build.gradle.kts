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
val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
val compileJava: JavaCompile by tasks

compileJava.destinationDir = compileKotlin.destinationDir


ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.parser"