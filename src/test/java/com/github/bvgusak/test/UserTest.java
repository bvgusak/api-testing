package com.github.bvgusak.test;

import com.github.bvgusak.BaseTest;
import com.github.bvgusak.data.UserObjectMother;
import com.github.bvgusak.dto.User;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

public class UserTest extends BaseTest {


    @Test
    public void shouldCreateNewUser() {
        User createUserBody = UserObjectMother.createRegularUser();

        User responseUserBody = userClient.createUser(createUserBody).prettyPeek()
                .then().statusCode(SC_CREATED)
                .and().contentType(ContentType.JSON)
                .and().extract().as(User.class);

        assertThat(responseUserBody).isEqualTo(createUserBody);
    }

    @Test
    public void shouldReturnTenUsers() {
        User[] users = userClient.getAllUsers()
                .then().statusCode(SC_OK)
                .and().contentType(ContentType.JSON)
                .and().extract().as(User[].class);

        assertThat(users).asList().hasSize(10);
    }

}
