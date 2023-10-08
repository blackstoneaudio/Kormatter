plugins {
    //trick: for the same plugin versions in all sub-modules
    kotlin("multiplatform").version("1.9.0").apply(true)
    id("maven-publish").apply(true)
}


group = "com.blackstone"
version = "0.1.0"


kotlin {
    targetHierarchy.default()
    jvm()
    js {
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

publishing {
    // this fetches our credentials from ~/.gradle/gradle.properties
    val mavenUser: String by project
    val mavenPassword: String by project

    repositories {
        maven {
            name = "reposiliteRepositoryReleases"
            setUrl("https://repos.awhb.dev/releases")
            authentication {
                create("basic", BasicAuthentication::class.java)
            }
            credentials {
                username = mavenUser
                password = mavenPassword
            }
        }
    }
}
