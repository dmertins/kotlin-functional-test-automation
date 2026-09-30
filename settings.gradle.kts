rootProject.name = "kotlin-functional-test-automation"

include(
    "acceptance-tests",
    "api-tests",
    "mobile-tests",
    "playwright-web-tests",
    "selenium-web-tests",
)

includeBuild("build-logic")

dependencyResolutionManagement {

    @Suppress("UnstableApiUsage")
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS

    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}
