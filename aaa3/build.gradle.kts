import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    `maven-publish`
}

android {
    namespace = "com.csstalker.aaa3"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    /*
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
    */
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                //groupId = "com.csstalker.aaa3poc"
                //artifactId = project.archivesName.get()
                groupId = "com.csstalker"
                artifactId = "aaa3"
                version = project.version.toString()
                pom.packaging = "aar"
                /*
                artifact("${layout.buildDirectory}/outputs/aar/aaa3-release.aar") {
                    builtBy(tasks.getByName("assemble"))
                }
                */
                afterEvaluate {
                    from(components["release"])
                }
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    api(libs.gson)
}