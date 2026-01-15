plugins {
    id("kotlin-junit-conventions")
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
