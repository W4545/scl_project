plugins {
    java
    application
}

dependencies {
    implementation(project(":BasicInterpreter-runtime"))
}

java {
    sourceCompatibility = Versions.JAVA_VERSION
    targetCompatibility = Versions.JAVA_VERSION
}

application {
    mainClass.set("dev.jacaro.school.cs4308.example.Main")
}

ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.example"