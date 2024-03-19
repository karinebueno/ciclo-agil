import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ResetPassword {

    String enderecoApi = "https://ciclo-agil-api-test.vercel.app";


    @Test
    @DisplayName("Criar um novo usuário")
    public void criarNovoUsuario() {
        given().contentType(ContentType.JSON)
                //.body("{\"name\": \"Karine Bueno\", \"email\": \"karinebueno.365@gmail.com\", \"password\": \"M159jCt\"}")
                .body("{\n" + "    \"name\": \"Karine Bueno\",\n" + "    \"email\": \"karinebueno.365@gmail.com\",\n" + "    \"password\": \"M159jCt\"\n" + "}")
                .when().post(enderecoApi + "/users")
                .then().statusCode(201)
                .body("name", Matchers.equalTo("Karine Bueno"))
                .body("email", Matchers.equalTo("karinebueno.365@gmail.com"));
    }


    @Test
    @DisplayName("Fazer login com novo usuario")
    public void LogarNewUser (){

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
    @DisplayName("Resetar a senha")
    public void resetPassword (){

        given().contentType(ContentType.JSON)
                .body("{\n" + "    \"email\": \"karinebueno.365@gmail.com\"\n" + "}")
                .when().post(enderecoApi + "/auth" + "/reset-password" + "/request")
                .then().statusCode(201)
                .body("message", Matchers.equalTo("Verification code sent to karinebueno.365@gmail.com"));
    }

}