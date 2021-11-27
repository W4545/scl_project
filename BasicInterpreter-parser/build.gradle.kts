plugins {
    `kotlin-dep`
}

dependencies {
    implementation(project(":BasicInterpreter-core"))
}

ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.parser"