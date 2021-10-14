plugins {
    java
    application
}

dependencies {
    implementation(project(":BasicInterpreter-core"))
    implementation(project(":BasicInterpreter-scanner"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

application {
    mainClass.set("dev.jacaro.school.cs4308.Main")
}

ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.runtime"