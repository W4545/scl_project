plugins {
    `java-lib`
}

dependencies {
    implementation(project(":BasicInterpreter-core"))

}

ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.scanner"