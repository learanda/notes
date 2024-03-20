// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        dependencies {
            classpath(libs.androidx.navigation.safeargs)
        }
    }
}

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.jetbrainsKotlinJvm) apply false
}