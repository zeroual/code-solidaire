package com.zeros.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Restaurant {

    private String name;
    private Location location;
    private String adress;
}
