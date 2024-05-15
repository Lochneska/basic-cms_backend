package com.example.basiccms_backend.model;

import com.example.basiccms_backend.dto.ContentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ContentArchive {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String thumbnail;
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="content_id", referencedColumnName = "id")
    private Content content;

    public ContentArchive(ContentDTO dto) {
        this.title = dto.title();
        this.thumbnail = dto.thumbnail();
        this.description = dto.description();
    }
}
