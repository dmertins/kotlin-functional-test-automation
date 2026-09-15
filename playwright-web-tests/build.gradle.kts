plugins {
    id("kotlin-junit-conventions")
}

dependencies {
    testImplementation(libs.playwright)
}

tasks.test {
    val browserTypePropertyName = "browserType"
    providers.gradleProperty(browserTypePropertyName).orNull?.let {
        systemProperty(browserTypePropertyName, it)
    }
}
