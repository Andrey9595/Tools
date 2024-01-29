
plugins {
    id("base-lib-convention")
}

android {
    namespace = "com.example.cloudstorage"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    implementation(libs.androidx.ktx)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.storage)
}