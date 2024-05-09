package com.example.basiccms_backend.service;

import com.example.basiccms_backend.model.Content;
import com.example.basiccms_backend.repo.ContentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    private ContentRepo cr;

    public ContentService(ContentRepo cr) {
        this.cr = cr;
    }

    public List<Content> getAllContent() {
        return cr.findAll();
    }

    public Optional<Content> getContentById(Long id) {
        return cr.findById(id);
    }

    public Content addContent(Content content) {
        return cr.save(content);
    }

}
