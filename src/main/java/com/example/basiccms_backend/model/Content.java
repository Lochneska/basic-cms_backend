package com.example.basiccms_backend.model;

import com.example.basiccms_backend.dto.ContentDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Content {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String thumbnail;
    private String description;


    public Content(ContentDTO dto) {
        this.title = dto.title();
        this.thumbnail = dto.thumbnail();
        this.description = dto.description();
    }
}
