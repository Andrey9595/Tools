plugins {
    `kotlin-dsl`
}
repositories {
    google {
        mavenContent {
            includeGroupByRegex(".*google.*")
            includeGroupByRegex(".*android.*")
        }
    }
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.androidGradlePlugin)
    implementation(libs.kotlinGradlePlugin)
}