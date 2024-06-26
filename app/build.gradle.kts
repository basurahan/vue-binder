plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "link.limecode.sample"
    compileSdk = 34

    defaultConfig {
        applicationId = "link.limecode.sample"
        minSdk = 26
        targetSdk = 34
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

    buildFeatures {
        viewBinding = true
    }

    kotlin {
        jvmToolchain(8)
    }
}

dependencies {

    implementation(libs.bundles.core.android)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.recycerview)

    implementation(project(":vue-binder"))
}