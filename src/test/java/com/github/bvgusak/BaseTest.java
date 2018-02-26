package com.github.bvgusak;

import com.github.bvgusak.client.UserClient;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected UserClient userClient;

    @BeforeMethod
    public void setUp() {
        userClient = new UserClient();
    }
}
