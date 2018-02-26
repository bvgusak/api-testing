package com.github.bvgusak.client;

import com.github.bvgusak.dto.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class UserClient extends RestConfig {

    /**
     * Get all users. Extract as {@link com.github.bvgusak.dto.User} array
     */
    public Response getAllUsers() {
        return when()
                .get(Endpoint.USERS);
    }

    /**
     * Get user by ID. Extract as {@link com.github.bvgusak.dto.User}
     *
     * @param id ID of user you want to get
     */
    public Response getUserById(String id) {
        return when()
                .get(Endpoint.USERS_ID, id);
    }

    /**
     * Create new user. Extact as {@link com.github.bvgusak.dto.User}
     *
     * @param user Body with user data.
     */
    public Response createUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(Endpoint.USERS);
    }

    public final static class Endpoint {

        public static final String USERS = "/users";
        public static final String USERS_ID = "/users/{id}";

        private Endpoint() {
        }
    }

}
