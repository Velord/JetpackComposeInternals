plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}


android {
    namespace = "com.velord.jetpackcomposeinternals"
    compileSdk = libs.versions.targetApi.get().toInt()

    defaultConfig {
        applicationId = "com.velord.jetpackcomposeinternals"
        minSdk = libs.versions.minApi.get().toInt()
        targetSdk = libs.versions.targetApi.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Templates
    implementation(libs.bundles.kotlin.module.app)
    implementation(libs.bundles.androidx.module.app)
    // Compose
    implementation(libs.bundles.compose.core)
    implementation(libs.bundles.compose.foundation)
    implementation(libs.bundles.compose.material)
    implementation(libs.bundles.compose.accompanist)
    implementation(libs.bundles.compose.thirdparty)
    implementation(libs.compose.paging)
    // Permission
    implementation(libs.sagar.coroutine.permission)
    // DI
    implementation(libs.bundles.dagger)
    kapt(libs.bundles.dagger.kapt)
    implementation(libs.bundles.hilt)
    kapt(libs.hilt.compiler)
    // Image Loader
    implementation(libs.coil)
    implementation(libs.coil.compose)
}