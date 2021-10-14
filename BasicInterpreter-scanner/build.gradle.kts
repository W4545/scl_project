plugins {
    `java-library`
}

dependencies {
    implementation(project(":BasicInterpreter-core"))

}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.scanner"