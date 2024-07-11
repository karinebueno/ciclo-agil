import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;


public class MestrualPeriodDate extends BaseTest {

    private static String accessToken;
    String birthdate = TestUtils.generateBirthday();
    String FutureDate = TestUtils.generateFutureDate();
    String invalidDates = TestUtils.generateRandomInvalidDate();

    @BeforeAll
    public static void obterToken() {
        accessToken = LoginUtil.obterToken();

        // Verifica se o accessToken não é nulo
        assertThat(accessToken, Matchers.notNullValue());
        System.out.println("accessToken: " + accessToken);
    }



    @Test
    @DisplayName("CT 001 –  Validação do endpoint para receber a data da última menstruação (Backend) – SUCESSO – DATA VALIDA")
    public void DataValida() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"date\": \"" + birthdate + "\"}")
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post("/menstrual-period/date")
                .then()
                .statusCode(201)
                .body("date", Matchers.equalTo(birthdate));
    }


    @Test
    @DisplayName("CT 002 –  Validação do endpoint para receber a data da última menstruação (Backend) – SUCESSO – DATA MESES ANTERIORES")
    public void DataMestruacaoAnterior() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"date\": \"" + birthdate + "\"}")
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post("/menstrual-period/date")
                .then()
                .statusCode(201)
                .body("date", Matchers.equalTo(birthdate));
    }

    @Test
    @DisplayName("CT 003 –  Validação do endpoint para receber a data da última menstruação (Backend) – INVALIDO – DATA FUTURA")
    public void DataFutura() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"date\": \"" + FutureDate + "\"}")
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post("/menstrual-period/date")
                .then()
                .statusCode(409)
                .body("message", Matchers.equalTo("Unauthorized"));
    }

    @Test
    @DisplayName("CT 003 –  Validação do endpoint para receber a data da última menstruação (Backend) – INVALIDO – DATA FUTURA")
    public void TesteDataFutura() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"date\": \"2024-08-15\"}")
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post("/menstrual-period/date")
                .then()
                .statusCode(409)
                .body("message", Matchers.equalTo("Unauthorized"));
    }

    @Test
    @DisplayName("CT 004 –  Validação do endpoint para receber a data da última menstruação (Backend) – INVALIDO – DATA INEXISTENTE")
    //deveria retornar 400 nesse caso e não um erro de servidor
    public void DataInexistente() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"date\": \"" + invalidDates + "\"}")
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post("/menstrual-period/date")
                .then()
                .statusCode(400)
                .body("code", Matchers.equalTo("invalid-time-value"));
    }

    @Test
    @DisplayName("CT 005 –  Validação do endpoint para receber a data da última menstruação (Backend) – INVALIDO – DATA REPETIDA")
    public void DataRepetida() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"date\": \"2024-01-01\"}")
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post("/menstrual-period/date")
                .then()
                .statusCode(409)
                .body("message", Matchers.equalTo("This date was already added."));
    }

    @Test
    @DisplayName("CT 006 –  Validação do endpoint para receber a data da última menstruação (Backend) – INVALIDO – SEM DATA")
    public void SemData() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"date\": \" \"}")
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .post("/menstrual-period/date")
                .then()
                .statusCode(400)
                .body("error", Matchers.equalTo("Bad Request"));
    }
}

/*public class LoginUtilTest extends BaseTest {
    @Test
    @DisplayName("Obtendo o token")
    public void testObterToken() {
        String accessToken = LoginUtil.obterToken();

        // Verifica se o accessToken não é nulo
        assertThat(accessToken, Matchers.notNullValue());
        System.out.println("accessToken: " + accessToken);


        // Exemplo de verificação adicional, se necessário
        //assertThat(accessToken, Matchers.startsWith("Bearer "));
    }*/
