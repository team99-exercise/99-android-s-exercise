@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.team99.exerciserhony"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.team99.exerciserhony"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        //todo, move to a secret properties file
        buildConfigField(
            "String",
            "BASE_URL",
            "\"https://ninetyninedotco-b7299.asia-southeast1.firebasedatabase.app/\""
        )
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
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
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

    implementation(libs.core.ktx)

    implementation(libs.lifecycle.runtimeKtx)
    implementation(libs.lifecycle.runtimeCompose)
    implementation(libs.lifecycle.viewmodel)

    implementation(libs.activity.compose)
    implementation(libs.constraintlayout)
    implementation(libs.navigation)
    implementation(libs.coil)

    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.moshiConverter)
    implementation(libs.squareup.moshi)
    ksp(libs.squareup.moshiCodegen)
    implementation(libs.squareup.okhttp)
    implementation(libs.squareup.loggingInterceptor)

    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}
