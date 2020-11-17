package com.accessment.demo.payload;

import com.accessment.demo.entity.Location;
import lombok.Data;

import java.util.List;

@Data
public class StoreUpdateRequest {
    private String type;

    private String address;

    private String state;

    private String hours;

    private String address2;

    private String zip;

    private String name;

    private String city;

    private List<String> services;

    private Location location;
}
