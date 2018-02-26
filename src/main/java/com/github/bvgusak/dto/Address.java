package com.github.bvgusak.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Accessors(chain = true)
public class Address {
    private String zipcode;
    private Geo geo;
    private String suite;
    private String city;
    private String street;
}
