import org.gradle.kotlin.dsl.annotationProcessor
import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp") version "2.2.0-2.0.2"
    id("kotlin-kapt")
    alias(libs.plugins.compose.compiler)

}

android {
    namespace = "com.faridnia.myapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.faridnia.myapplication"
        minSdk = 33
        targetSdk = 35
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14" // Use the version compatible with your Kotlin version
    }

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.room.compiler)
    implementation(libs.androidx.runtime.android)
    implementation(libs.androidx.ui.tooling.preview.android)

    implementation(libs.androidx.runtime) // Use the latest stable version
    // You might also need other Compose artifacts like ui, material, foundation, etc.
    implementation(libs.androidx.ui)
    implementation(libs.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.retrofit)
    implementation(libs.play.services.location)

    implementation (libs.androidx.room.runtime)

    implementation(libs.dagger.compiler)
    ksp(libs.dagger.compiler)

    // Dependency Injection
    implementation (libs.hilt.android)
    annotationProcessor (libs.hilt.android.compiler)
    ksp (libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

}