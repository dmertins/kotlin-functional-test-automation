plugins {
    id("kotlin-junit-conventions")
}

dependencies {
    testImplementation(platform(libs.rest.assured.bom))
    testImplementation(libs.bundles.rest.assured)

    constraints {
        testImplementation("commons-codec:commons-codec:1.13") {
            because("versions before 1.13 are vulnerable")
        }
        testImplementation("com.fasterxml.jackson.core:jackson-core:2.15.0") {
            because("versions before 2.15.0 are vulnerable")
        }
    }
}
