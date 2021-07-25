pluginManagement {
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
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
