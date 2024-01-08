@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "com.catnip.hotelier"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.catnip.hotelier"
        minSdk = 24
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
    flavorDimensions += "environment"
    productFlavors {
        create("mockEnv") {
            dimension = "environment"
            buildConfigField("String", "BASE_URL", "\"https://ninetyninedotco-b7299.asia-southeast1.firebasedatabase.app\"")
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
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.androidx.swiperefreshlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.coroutine)
    implementation(libs.bundles.retrofit)
    implementation(libs.coil)
    implementation(libs.koin.android)
    implementation(libs.androidx.startup)
    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.noop)
}