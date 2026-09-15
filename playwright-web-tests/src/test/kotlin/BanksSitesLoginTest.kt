import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserContext
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
        page.navigate(url)
        assertThat(page).hasTitle(expectedTitle)
    }

    @BeforeAll fun launchBrowser() {
        playwright = Playwright.create()

        val browserType = when (browserTypeProperty) {
            BrowserTypeProperty.CHROMIUM -> playwright.chromium()
            BrowserTypeProperty.FIREFOX -> playwright.firefox()
            BrowserTypeProperty.WEBKIT -> playwright.webkit()
        }

        val launchOptions = BrowserType.LaunchOptions().setHeadless(false)

        browser = browserType.launch(launchOptions)
    }

    @BeforeEach fun createContextAndPage() {
        context = browser.newContext()
        page = browser.newPage()
    }

    @AfterEach fun closeContext() = context.close()

    @AfterAll fun closeBrowser() = playwright.close()

    lateinit var playwright: Playwright
    lateinit var browser: Browser

    lateinit var context: BrowserContext
    lateinit var page: Page

    enum class BrowserTypeProperty { CHROMIUM, FIREFOX, WEBKIT }
    val browserTypeProperty = BrowserTypeProperty.valueOf(
        System.getProperty("browserType", "chromium").uppercase()
    )
}
