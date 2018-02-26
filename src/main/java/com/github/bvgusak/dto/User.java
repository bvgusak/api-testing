package com.github.bvgusak.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Accessors(chain = true)
public class User {
    private String website;
    private Address address;
    private String phone;
    private String name;
    private Company company;
    private int id;
    private String email;
    private String username;
}
