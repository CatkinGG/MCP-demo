plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.mcp_demo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.mcp_demo"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.androidx.foundation.android)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.ui.tooling.preview.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation("androidx.compose.ui:ui:1.8.2")
    implementation("androidx.compose.ui:ui-tooling-preview:1.8.2")
    implementation(libs.androidx.material3)
    debugImplementation("androidx.compose.ui:ui-tooling:1.8.2")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.8.2")
}