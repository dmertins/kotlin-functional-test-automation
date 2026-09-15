<h1 align="center"> Kotlin Functional Test Automation Demo </h1>

<p align="center"> Functional test automation demo with Kotlin and leading test automation tools. </p>

## Technology Stack
[Kotlin](https://kotlinlang.org/) &nbsp; • &nbsp;
[JUnit](https://junit.org/) &nbsp; • &nbsp;
[Gradle](https://gradle.org/)

## Test Automation Tools
[REST Assured](https://rest-assured.io/) &nbsp; • &nbsp;
[Selenium](https://www.selenium.dev/) &nbsp; • &nbsp;
[Playwright](https://playwright.dev/) &nbsp; • &nbsp;
[Appium](https://appium.io/) &nbsp; • &nbsp;
[Cucumber](https://cucumber.io/)

## Requirements
[JDK](https://adoptium.net/) ≥ 21

## Running the Tests

### API Tests
Running the API tests:
```shell
  ./gradlew :api-tests:test
```

### Selenium Web Tests
The browser in which the tests run is defined through the Gradle Project Property `browser`.

| Browser            | Property Value |
|--------------------|----------------|
| Chrome (_default_) | `chrome`       |
| Edge               | `edge`         |
| Firefox            | `firefox`      |
| Safari             | `safari`       |

To enable automation on Safari:
```shell
  safaridriver --enable
```

Running the tests in default browser (Chrome):
```shell
  ./gradlew :selenium-web-tests:test
```

Running the tests in a specific browser:
```shell
  ./gradlew :selenium-web-tests:test -Pbrowser=firefox
```
