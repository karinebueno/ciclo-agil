import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TesteLogin {

    String enderecoApi = "https://ciclo-agil-api-test.vercel.app/auth/login";


    @Test
    @DisplayName("Fazer login no aplicativo ciclo ágil com sucesso")
    public void Login (){

        given().contentType(ContentType.JSON)
                .body("{\"email\": \"cexov78826@rencr.com\", \"password\": \"Pipoca123+\"}")
                .when().post(enderecoApi)
                .then().statusCode(201)
                .body("user.name", Matchers.equalTo("Novo Usuario Teste"))
                //.body("user.lastName", Matchers.equalTo("Jane"))
                .body("user.email", Matchers.equalTo("cexov78826@rencr.com"))
                .body("token.accessToken", Matchers.notNullValue())
                .body("token.refreshToken", Matchers.notNullValue());

    }

    @Test
    @DisplayName("Fazer login no aplicativo ciclo ágil com email inválido")
    public void EmailInvalido () {

        given().contentType(ContentType.JSON)
                .body("{\"email\": \"maria@jane.com\", \"password\": \"Mary@jane1234\"}")
                .when().post(enderecoApi)
                .then().statusCode(401)
                .body("message", Matchers.equalTo("Invalid email or password"));

    }

    @Test
    @DisplayName("Fazer login no aplicativo ciclo ágil com email sem dominio")
    public void EmailSemDominio () {

        given().contentType(ContentType.JSON)
                .body("{\"email\": \"mary@\", \"password\": \"Mary@jane1234\"}")
                .when().post(enderecoApi)
                .then().statusCode(400)
                .body("message", Matchers.hasItem("email must be an email"));

    }

    @Test
    @DisplayName("Fazer login no aplicativo ciclo ágil com a senha inválida")
    public void LoginComSenhaInvalida () {

        given().contentType(ContentType.JSON)
                .body("{\"email\": \"mary@jane.com\", \"password\": \"karine\"}")
                .when().post(enderecoApi)
                .then().statusCode(401)
                .body("message", Matchers.equalTo("Invalid email or password"));
    }

    @Test
    @DisplayName("Fazer login no aplicativo ciclo ágil com campo email vazio")
    public void EmailVazio () {

        given().contentType(ContentType.JSON)
                .body("{\"email\": \"\", \"password\": \"Mary@jane1234\"}")
                .when().post(enderecoApi)
                .then().statusCode(400)
                .body("message", Matchers.hasItem("email must be an email"))
                .body("message", Matchers.hasItem("email should not be empty"));

    }
    @Test
    @DisplayName("Fazer login no aplicativo ciclo ágil com campo senha vazio")
    public void SenhaVazio () {

        given().contentType(ContentType.JSON)
                .body("{\"email\": \"mary@jane.com\", \"password\": \"\"}")
                .when().post(enderecoApi)
                .then().statusCode(400)
                .body("message", Matchers.hasItem("password should not be empty"));

    }
}
