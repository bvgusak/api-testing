package com.github.bvgusak.data;

import com.github.javafaker.Faker;

public abstract class ObjectMother {

    protected static Faker faker;

    static {
        faker = new Faker();
    }
}
