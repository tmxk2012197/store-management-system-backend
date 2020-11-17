package com.accessment.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "store")
public class Store {
    @Transient
    public static final String SEQUENCE_NAME = "store_sequence";

    @Id
    private String objectId;

    @NotNull
    @Indexed(unique = true)
    @Field(name = "id")
    private Long externalId;

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
