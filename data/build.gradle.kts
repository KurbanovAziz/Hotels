plugins {
    id(Plugins.AGP.library)
    kotlin(Plugins.Kotlin.android)
}

android {
    namespace = Namespaces.data

    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
    }

    buildTypes {
        getByName(AndroidConfig.release) {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
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
    }
}

dependencies {

    // Module
    implementation(project(":domain"))

    // Retrofit
    implementation(Libraries.Retrofit.retrofit)
    implementation(Libraries.Retrofit.gsonConverter)

    // Interceptor
    implementation(Libraries.OkHttp.loggingInterceptor)
}