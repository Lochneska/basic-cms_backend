package com.example.basiccms_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Content {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String thumbnail;
    private String description;
}