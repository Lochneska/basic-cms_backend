package com.example.basiccms_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Content {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String thumbnail;
    private String description;
}
