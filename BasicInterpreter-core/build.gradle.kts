plugins {
    `kotlin-dep`
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:${Versions.KOTLIN_VERSION}")
}

tasks {
    build.configure {
        dependsOn(clean)
    }
}
ext.properties["moduleName"] = "dev.jacaro.basicinterpreter.core"
