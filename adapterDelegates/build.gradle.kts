
plugins {
    id("viewbinding-lib-convention")
}

android {
    namespace = "com.example.adapterdelegates"

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
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.recyclerView)
}