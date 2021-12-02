plugins {
    id("org.jetbrains.dokka") version "1.6.0"
}

tasks.dokkaGfmMultiModule.configure {
    outputDirectory.set(buildDir.resolve("dokkaCustomMultiModuleOutput"))
}

allprojects {
    apply(plugin = "org.jetbrains.dokka")

    repositories {
        mavenCentral()
    }
}

subprojects {
    version = "0.5.0"
    group = "parts.lost"
}