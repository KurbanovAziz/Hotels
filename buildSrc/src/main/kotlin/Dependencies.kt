object Versions {

    const val AGP = "7.3.0"
    const val kotlin = "1.8.21"
    const val coroutines = "1.7.1"
    const val material = "1.9.0"
    const val constraintLayout = "2.1.4"
    const val appCompat = "1.6.1"
    const val vbpd = "1.5.9"
    const val core = "1.10.1"
    const val fragment = "1.5.7"
    const val lifecycle = "2.6.1"
    const val navigation = "2.5.3"
    const val dagger = "2.46.1"
    const val retrofit = "2.9.0"
    const val okHttp = "5.0.0-alpha.11"
    const val room = "2.5.1"
    const val circleIndicator = "2.1.6"
    const val glide = "4.13.2"
    const val google = "20.4.1"
    const val gsonConverter ="2.5.0"
    const val interceptor ="5.0.0-alpha.2"

}

object Libraries {
    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${
            Versions.coroutines
        }"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${
            Versions.coroutines
        }"
    }

    object UIComponents {
        const val material = "com.google.android.material:material:${
            Versions.material
        }"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${
            Versions.constraintLayout
        }"
        const val appCompat = "androidx.appcompat:appcompat:${
            Versions.appCompat
        }"
        const val vbpd = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${
            Versions.vbpd
        }"
    }

    object Core {
        const val core = "androidx.core:core-ktx:${Versions.core}"
    }

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    }

    object Navigation {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Javax {
        const val inject = "javax.inject:javax.inject:1"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${Versions.dagger}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.dagger}"
    }


    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
    }

    object OkHttp {
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    }

    object CircleIndicator {
        const val circleIndicator = "me.relex:circleindicator:${Versions.circleIndicator}"
    }
}
object Plugins {

    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val android = "android"
        const val jvm = "jvm"
        const val kapt = "kapt"
    }

    object Hilt {
        const val android = "com.google.dagger.hilt.android"
    }
}