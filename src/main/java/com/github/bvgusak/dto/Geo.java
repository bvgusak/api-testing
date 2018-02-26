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
public class Geo {
    private String lng;
    private String lat;
}
