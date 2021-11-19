plugins {
    `java-library`
    id("org.jetbrains.kotlin.jvm") version "1.6.0"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
val compileJava: JavaCompile by tasks

compileJava.destinationDirectory.set(compileKotlin.destinationDirectory)

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.majorVersion
        freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    }
}

ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.core"
