plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("co.touchlab.skie") version "0.7.1"
    kotlin("plugin.serialization") version "1.9.20"
    alias(libs.plugins.sqlDelight)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.kotlinx.datetime)
            implementation(libs.koin.core)
            implementation(libs.sql.coroutines)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.lifecycle.viewmodel.ktx)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.sql.android.driver)
            }
        }

        val iosArm64Main by getting {
            dependencies {
                implementation(libs.ktor.client.darwin)
                implementation(libs.sql.native.driver)
                implementation(libs.stately.common)
            }
        }
        val iosArm64Test by getting {
            dependencies {
                implementation(libs.ktor.client.darwin)
                implementation(libs.sql.native.driver)
                implementation(libs.stately.common)
            }
        }
        val iosX64Main by getting {
            dependencies {
                implementation(libs.ktor.client.darwin)
                implementation(libs.sql.native.driver)
                implementation(libs.stately.common)
            }
        }
        val iosSimulatorArm64Main by getting {
            dependencies {
                implementation(libs.ktor.client.darwin)
                implementation(libs.sql.native.driver)
                implementation(libs.stately.common)
            }
        }

    }
}

android {
    namespace = "com.marcoantonio95.dailypulse"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

sqldelight {
    databases {
        create(name = "DailyPulseDatabase") {
            packageName.set("com.marcoantonio95.dailypulse.db")
        }
    }
}