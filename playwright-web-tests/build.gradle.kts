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

tasks.register<JavaExec>("playwrightCli") {
    group = "Playwright"
    description = "Runs the Playwright CLI."
    classpath(sourceSets["test"].runtimeClasspath)
    mainClass.set("com.microsoft.playwright.CLI")
}
