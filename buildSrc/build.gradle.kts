plugins {
  id("java-gradle-plugin")
  `kotlin-dsl`
}

gradlePlugin {
  plugins {
    create("androidLibrary") {
      id = "android-library"
      implementationClass = "AndroidLibrary"
    }
    create("androidBinary") {
      id = "android-binary"
      implementationClass = "AndroidBinary"
    }
  }
}

dependencies {
  implementation(deps.agp)
  implementation(deps.kotlin)
  implementation(deps.spotless)
}
