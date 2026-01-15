import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.safari.SafariDriver
import org.openqa.selenium.support.ui.ExpectedConditions.titleIs
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class `Bank websites should have expected page title` {

    @DisplayName("Page title of")
    @ParameterizedTest(name = "[{index}] {0} is {1}")
    @CsvSource(
        "https://www.itau.com.br, Abra sua conta no Banco Itaú: Soluções financeiras para você",
        "https://www.bb.com.br, Pra Você | Banco do Brasil",
        "https://banco.bradesco, Banco Bradesco | Você primeiro",
        "https://www.caixa.gov.br, CAIXA",
        "https://www.santander.com.br, Santander",
    )
    fun testWebsitePageTitle(url: String, expectedTitle: String) {
        driver.get(url)
        wait.until(titleIs(expectedTitle))
    }

    lateinit var driver: WebDriver
    lateinit var wait: WebDriverWait

    enum class Browser { CHROME, EDGE, FIREFOX, SAFARI }
    val browser = Browser.valueOf(
        System.getProperty("browser", "chrome").uppercase()
    )

    @BeforeEach fun setup() {
        driver = createWebDriver()
        wait = WebDriverWait(driver, Duration.ofSeconds(5))
    }

    @AfterEach fun teardown() {
        driver.quit()
    }

    fun createWebDriver(): WebDriver =
        when (browser) {
            Browser.CHROME -> ChromeDriver()
            Browser.EDGE -> EdgeDriver()
            Browser.FIREFOX -> FirefoxDriver()
            Browser.SAFARI -> SafariDriver()
    }
}
