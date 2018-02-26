package com.github.bvgusak.data;

import com.github.bvgusak.dto.Address;
import com.github.bvgusak.dto.Geo;

public class AddressObjectMother extends ObjectMother {

    public static Address getBasicAddress() {
        return new Address()
                .setCity(faker.address().city())
                .setGeo(new Geo()
                        .setLat(faker.address().latitude())
                        .setLng(faker.address().longitude()))
                .setStreet(faker.address().streetAddress())
                .setSuite(faker.address().buildingNumber())
                .setZipcode(faker.address().zipCode());
    }

}
