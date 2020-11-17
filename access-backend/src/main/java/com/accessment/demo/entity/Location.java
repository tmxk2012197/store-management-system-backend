package com.accessment.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private Double lat;

    private Double lon;
}
