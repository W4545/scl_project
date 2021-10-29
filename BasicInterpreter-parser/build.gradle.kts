plugins {
    `java-library`
    id("org.jetbrains.kotlin.jvm") version "1.5.0"
}

dependencies {
    implementation(project(":BasicInterpreter-core"))
    implementation(project(":BasicInterpreter-scanner"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.parser"