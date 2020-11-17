package com.accessment.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "store_sequence")
public class DatabaseSequence {
    @Id
    private String id;

    private Long seq;
}
