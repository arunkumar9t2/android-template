plugins {
  `kotlin-dsl`
}

dependencies {
  compileOnly(deps.agp)
  compileOnly(deps.kotlin)
  implementation(deps.spotless)
}
