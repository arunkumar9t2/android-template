pluginManagement {
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
  }
  plugins {
    id("com.android.application") version "7.1.0-alpha04"
    id("com.android.library") version "7.1.0-alpha04"
    id("org.jetbrains.kotlin.android") version "1.5.10"
  }
}
enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
  repositories {
    google()
    mavenCentral()
  }
  defaultLibrariesExtensionName.set("deps")
  versionCatalogs {
    create("deps") {
      from(files("../gradle/libs.versions.toml"))
    }
  }
}
