import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoginUtil {

    private static final String LOGIN_ENDPOINT = "https://ciclo-agil-api-test.vercel.app/auth/login";

    public static String obterToken() {

        Response response = given().contentType(ContentType.JSON)
                .body("{\"email\": \"maria12@globo.com\", \"password\": \"Teste@123\"}")
                .when().post(LOGIN_ENDPOINT)
                .then().statusCode(201)
                .extract().response();
        return response.jsonPath().getString("token.accessToken");

    }

}
