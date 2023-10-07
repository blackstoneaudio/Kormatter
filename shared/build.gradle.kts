plugins {
    kotlin("multiplatform")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()
    jvm()
    js() {
        browser { binaries.executable() }
        nodejs { binaries.executable() }
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
        watchosSimulatorArm64(),
        watchosX64(),
        watchosArm64(),
        macosArm64(),
        macosX64()
    ).forEach {
        it.binaries.framework {
            baseName = "kormatter"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val nativeMain by getting {}

    }
}
