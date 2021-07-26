/*
 * Copyright 2021 Arunkumar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ANDROID_COMPILE_SDK = 31
val ANDROID_MIN_SDK = 25
val ANDROID_TARGET_SDK = 31

val RELEASE_VARIANT = "release"

internal fun Project.androidCommon() {
  apply(plugin = "org.jetbrains.kotlin.android")

  configure<BaseExtension> {
    compileSdkVersion(ANDROID_COMPILE_SDK)

    defaultConfig {
      minSdk = ANDROID_MIN_SDK
      targetSdk = ANDROID_TARGET_SDK

      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
      vectorDrawables {
        useSupportLibrary = true
      }
    }

    buildTypes {
      named(RELEASE_VARIANT) {
        minifyEnabled(true)
        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      }
    }

    compileOptions {
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
      kotlinCompilerExtensionVersion = deps.findVersion("compose").get().toString()
    }
  }

  tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
      jvmTarget = "1.8"
    }
  }
}
