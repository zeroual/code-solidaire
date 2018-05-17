package com.zeros.backend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Restaurant {

    private final String name;
    private final Location location;
    private final String formattedAddress;

}
