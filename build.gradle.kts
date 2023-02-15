buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven {
            setUrl("https://jitpack.io")
        }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${libs.versions.gradle.get()}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin.get()}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${libs.versions.hilt.get()}")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}