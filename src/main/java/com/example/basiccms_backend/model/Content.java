package com.example.basiccms_backend.model;

import com.example.basiccms_backend.dto.ContentDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "content")
    private Set<ContentArchive> archive = new HashSet<>();


    public Content(ContentDTO dto) {
        this.title = dto.title();
        this.thumbnail = dto.thumbnail();
        this.description = dto.description();
    }
}
