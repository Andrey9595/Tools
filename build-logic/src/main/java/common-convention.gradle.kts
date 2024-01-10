import com.android.build.gradle.BaseExtension

plugins {
    id("kotlin-android")
}

configure<BaseExtension> {
    compileSdkVersion(34)
    
    defaultConfig {
        minSdk = 24
        targetSdk = 34
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}