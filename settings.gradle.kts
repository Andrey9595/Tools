pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}


rootProject.name = "Tools"
includeBuild("build-logic")
include(":app")
include(":auth")
include(":feature:login")
include(":core")
include(":feature:root")
include(":feature:home")
