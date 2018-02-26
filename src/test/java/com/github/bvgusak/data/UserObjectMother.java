package com.github.bvgusak.data;

import com.github.bvgusak.dto.Company;
import com.github.bvgusak.dto.User;

public class UserObjectMother extends ObjectMother {

    public static final User createRegularUser() {
        return new User()
                .setEmail(faker.internet().safeEmailAddress())
                .setUsername(faker.name().username())
                .setWebsite(faker.internet().url())
                .setPhone(faker.phoneNumber().phoneNumber())
                .setAddress(AddressObjectMother.getBasicAddress())
                .setName(faker.name().firstName())
                .setCompany(new Company()
                        .setBs(faker.company().bs())
                        .setCatchPhrase(faker.company().catchPhrase())
                        .setName(faker.company().name()));
    }

}
