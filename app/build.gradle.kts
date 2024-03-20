plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("kapt")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.learanda.memorynotes"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.learanda.memorynotes"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(path = ":core"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    implementation(libs.androidx.recyclerview)

    implementation(libs.androidx.navigation.fragment.ktx)

    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.android.arch.lifecycle)

    implementation(libs.squareup.retrofit2.retrofit)
    implementation(libs.squareup.retrofit2.converterGson)

    implementation(libs.jetbrains.kotlinx.coroutines.core)
    implementation(libs.jetbrains.kotlinx.coroutines.android)

    implementation(libs.androidx.room)
    implementation(libs.androidx.legacy.supportV4)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    implementation(libs.google.dagger)
    implementation(libs.google.dagger.android.support)
    kapt(libs.google.dagger.compiler)
    kapt(libs.google.dagger.android.processor)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}