plugins {
    `kotlin-dep`
}

dependencies {
    implementation(project(":BasicInterpreter-core"))
    implementation(project(":BasicInterpreter-parser"))
}

ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.executor"