plugins {
    id(Plugins.AGP.application)
    kotlin(Plugins.Kotlin.android)
    kotlin(Plugins.Kotlin.kapt)

    // Hilt
    id(Plugins.Hilt.android)
}

android {
    namespace = Namespaces.app

    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.kitepkana"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName(AndroidConfig.release) {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }

        getByName(AndroidConfig.debug) {
            applicationIdSuffix = ".${AndroidConfig.debug}"
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = Options.compileOptions
        targetCompatibility = Options.compileOptions
    }
    kotlinOptions {
        jvmTarget = Options.kotlinOptions
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    dependencies {

        // Kotlin
        implementation(Libraries.Coroutines.android)

        // UI Components
        implementation(Libraries.UIComponents.material)
        implementation(Libraries.UIComponents.constraintLayout)
        implementation(Libraries.UIComponents.appCompat)
        implementation(Libraries.UIComponents.vbpd)

        // Core
        implementation(Libraries.Core.core)

        // Lifecycle
        implementation(Libraries.Lifecycle.viewModel)
        implementation(Libraries.Lifecycle.liveData)

        // Navigation
        implementation(Libraries.Navigation.fragment)
        implementation(Libraries.Navigation.ui)

        // Hilt
        implementation(Libraries.Hilt.android)
        kapt(Libraries.Hilt.compiler)

        // Glide
        implementation(Libraries.Glide.glide)

        // CircleIndicator
        implementation(Libraries.CircleIndicator.circleIndicator)

        // Retrofit
        implementation(Libraries.Retrofit.retrofit)
        implementation(Libraries.Retrofit.gsonConverter)

        //Interceptor
        implementation(Libraries.OkHttp.loggingInterceptor)

        implementation("com.hannesdorfmann:adapterdelegates4:4.3.0")
    }
}
dependencies {
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))
}
