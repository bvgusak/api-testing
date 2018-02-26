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
public class Company {
    private String bs;
    private String catchPhrase;
    private String name;
}
