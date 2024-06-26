import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ResetPassword {

    String enderecoApi = "https://ciclo-agil-api-test.vercel.app";


    @Test
    @DisplayName("Resetar a senha com sucesso")
    public void SuccessfulRequest() {
        given().contentType(ContentType.JSON)
                .body("email:testetimebordo@gmail.com")
                .when().post(enderecoApi + "/auth" + "/reset-password" + "/request")
                .then().statusCode(201)
                .body("message", Matchers.equalTo("Verification code sent to rayandson.silva321@gmail.com"));
    }


    @Test
    @DisplayName("Deixar o email pra resetar a senha vazio")
    public void RequestEmpty (){
        given().contentType(ContentType.JSON)
                .body("{\n" + "  \"email\": \"karinebueno.365@gmail.com\",\n" + "  \"password\": \"M159jCt\"\n" + "}")
                .when().post(enderecoApi + "/auth" + "/login")
                .then().statusCode(201)
                .body("user.name", Matchers.equalTo("Karine Bueno"))
                .body("user.email", Matchers.equalTo("karinebueno.365@gmail.com"))
                .body("token.accessToken", Matchers.notNullValue())
                .body("token.refreshToken", Matchers.notNullValue());
    }

    @Test
    @DisplayName("Passar um email que não está registrado para resetar a senha")
    public void EmailNotRegistered (){

        given().contentType(ContentType.JSON)
                .body("{\n" + "    \"email\": \"karinebueno.365@gmail.com\"\n" + "}")
                .when().post(enderecoApi + "/auth" + "/reset-password" + "/request")
                .then().statusCode(201)
                .body("message", Matchers.equalTo("Verification code sent to karinebueno.365@gmail.com"));
    }

}