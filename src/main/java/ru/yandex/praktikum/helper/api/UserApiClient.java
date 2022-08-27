package ru.yandex.praktikum.helper.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserApiClient extends RestAssuredClient {

    private String bearerToken = "";

    public Response authorization(UserReqJson body) {
        Response response = reqSpec
                .contentType(ContentType.JSON)
                .body(body)
                .post("/auth/login");
        extractToken(response);
        return response;
    }

    public Response createUser(UserReqJson json) {
        Response response = reqSpec
                .contentType(ContentType.JSON)
                .body(json)
                .post("/auth/register");
        extractToken(response);
        return response;
    }

    public void clearAuthToken() {
        bearerToken = "";
    }

    private void extractToken(Response response) {
        if (response.statusCode() == 200) {
            bearerToken = response.then().extract().body().path("accessToken");
        } else {
            clearAuthToken();
        }
    }

    public void deleteUser() {
        reqSpec.header("Authorization", bearerToken)
                .delete("/auth/user");
    }
}