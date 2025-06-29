plugins {
    id("kotlin-conventions")
}

dependencies {
    testImplementation(platform("io.rest-assured:rest-assured-bom:5.5.5"))
    testImplementation("io.rest-assured:rest-assured")
    testImplementation("io.rest-assured:kotlin-extensions")
    testImplementation("io.rest-assured:json-schema-validator")

    constraints {
        testImplementation("commons-codec:commons-codec:1.13") {
            because("versions before 1.13 are vulnerable")
        }
        testImplementation("com.fasterxml.jackson.core:jackson-core:2.15.0") {
            because("versions before 2.15.0 are vulnerable")
        }
    }
}
