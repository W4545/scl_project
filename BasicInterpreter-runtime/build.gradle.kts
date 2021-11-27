plugins {
    java
    application
}

dependencies {
    implementation(project(":BasicInterpreter-core"))
    implementation(project(":BasicInterpreter-scanner"))
    implementation(project(":BasicInterpreter-parser"))
    implementation(project(":BasicInterpreter-executor"))
}

java {
    sourceCompatibility = Versions.JAVA_VERSION
    targetCompatibility = Versions.JAVA_VERSION
}

application {
    mainClass.set("dev.jacaro.school.cs4308.Main")
}

ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.runtime"