package api;

import constants.Api;
import constants.ContentType;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ClientApi {

    private static final File client = new File("src/test/resources/client.json");
    private static final File loginClient = new File("src/test/resources/clientLogin.json");

    @Step("Создание клиента")
    public void createClient() {
        given()
                .contentType(ContentType.CONTENT_TYPE)
                .body(client)
                .when()
                .post(Api.CLIENT_API_REGISTRATION)
                .then()
                .statusCode(200)
                .body("success", equalTo(true));
    }

    @Step("Получить accessToken по клиенту")
    public static String loginAndExtractAccessTokenOfClient() {
        Response response = given()
                .contentType(ContentType.CONTENT_TYPE)
                .body(loginClient)
                .when()
                .post(Api.CLIENT_LOGIN_API_ENDPOINT)
                .then()
                .statusCode(200)
                .body("accessToken", notNullValue())
                .extract()
                .response();

        return response.path("accessToken");
    }

    @Step("Удалить клиента")
    public static void deleteClient(String clientToken) {
        given()
                .header("Authorization", clientToken)
                .when()
                .delete(Api.FOR_ACTIONS_ON_THE_CLIENT)
                .then()
                .statusCode(202)
                .body("success", equalTo(true));
    }
}
