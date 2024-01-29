import java.util.Properties

plugins {
    id("viewbinding-lib-convention")
}

android {
    namespace = "ru.anb.login"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        val keystoreFile = project.rootProject.file("keys.properties")
        val properties = Properties()
        properties.load(keystoreFile.inputStream())
        val webIdClientKey = properties.getProperty("WEB_CLIENT_ID") ?: ""
        buildConfigField("String", "WEB_CLIENT_ID", webIdClientKey)
    }

    buildFeatures {
        buildConfig = true
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
}

dependencies {
    implementation(project(":core"))
    implementation(project(":auth"))
    implementation(libs.androidx.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.koin.android)
    implementation(libs.googlePlay.auth)
}