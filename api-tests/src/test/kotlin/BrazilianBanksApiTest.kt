import io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.CoreMatchers.hasItems
import org.junit.jupiter.api.Test

class `Banks list should contain` {

    @Test fun `the five largest banks by total assets`() {
        Given {
            baseUri("https://brasilapi.com.br/api")
        } When {
            get("/banks/v1")
        } Then {
            statusCode(200)
            body("fullName", hasItems(
                "ITAÚ UNIBANCO S.A.",
                "Banco do Brasil S.A.",
                "Banco Bradesco S.A.",
                "CAIXA ECONOMICA FEDERAL",
                "BANCO SANTANDER (BRASIL) S.A.",
            ))
        }
    }

    @Test fun `the five largest banks by total customer base`() {
        Given {
            baseUri("https://brasilapi.com.br/api")
        } When {
            get("/banks/v1")
        } Then {
            statusCode(200)
            body("fullName", hasItems(
                "CAIXA ECONOMICA FEDERAL",
                "Banco Bradesco S.A.",
                "NU PAGAMENTOS S.A. - INSTITUIÇÃO DE PAGAMENTO",
                "ITAÚ UNIBANCO S.A.",
                "Banco do Brasil S.A.",
            ))
        }
    }
}

class `Banks list data should have` {

    @Test fun `expected json schema`() {
        Given {
            baseUri("https://brasilapi.com.br/api")
        } When {
            get("/banks/v1")
        } Then {
            statusCode(200)
            body(matchesJsonSchemaInClasspath("banks-list.schema.json"))
        }
    }
}
