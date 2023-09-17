buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.0")
    }
}
plugins {
    id(Plugins.AGP.application) version Versions.AGP apply false
    id(Plugins.AGP.library) version Versions.AGP apply false
    kotlin(Plugins.Kotlin.android) version Versions.kotlin apply false
    // Hilt
    id(Plugins.Hilt.android) version Versions.dagger apply false
}