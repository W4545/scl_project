plugins {
    java
    application
}

dependencies {
    implementation(project(":BasicInterpreter-runtime"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

application {
    mainClass.set("dev.jacaro.school.cs4308.example.Main")
}

ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.example"