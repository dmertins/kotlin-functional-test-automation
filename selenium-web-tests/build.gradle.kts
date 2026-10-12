plugins {
    id("buildlogic.conventions.kotlin-junit")
}

dependencies {
    testImplementation(libs.selenium)
}

tasks.test {
    val browserPropertyName = "browser"
    providers.gradleProperty(browserPropertyName).orNull?.let {
        systemProperty(browserPropertyName, it)
    }
}
