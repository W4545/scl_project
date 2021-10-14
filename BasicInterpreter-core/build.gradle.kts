plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.core"
