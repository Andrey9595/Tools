plugins {
    id("app-convention")
    alias(libs.plugins.google.services)
}

android {
    namespace = "ru.anb.tools"

    defaultConfig {
        applicationId = "ru.anb.tools"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":feature:root")) // TODO: remove?
    implementation(project(":core"))
    implementation(project(":feature:login")) // TODO: remove?
    implementation(project(":feature:home")) // TODO: remove?
    implementation(project(":auth"))
    implementation(libs.androidx.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.koin.android)

}