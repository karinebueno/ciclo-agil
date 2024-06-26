import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CreateUser extends BaseTest {

    @Test
    public void createUser() {
        String name = TestUtils.generateName();
        String email = TestUtils.generateEmail(name);
        String password = TestUtils.generatePassword();
        String birthdate = TestUtils.generateBirthday();

        // Log the generated data
        System.out.println("Generated data:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Birthdate: " + birthdate);

        given()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"" + name + "\", \"email\": \"" + email + "\", \"password\": \"" + password + "\", \"birthdate\": \"" + birthdate + "\" }")
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("user.name", equalTo(name))
                .body("user.email", equalTo(email))
                .body("token.accessToken", not(empty()))
                .body("token.refreshToken", not(empty()));
    }
}
