package com.example.basiccms_backend.service;

import com.example.basiccms_backend.dto.ContentDTO;
import com.example.basiccms_backend.model.Content;
import com.example.basiccms_backend.model.ContentArchive;
import com.example.basiccms_backend.repo.ContentArchiveRepo;
import com.example.basiccms_backend.repo.ContentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    private final ContentRepo cr;
    private final ContentArchiveRepo car;

    public ContentService(ContentRepo cr, ContentArchiveRepo car) {
        this.cr = cr;
        this.car = car;
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

    public Content updateContent(Long id, ContentDTO dto) {
        if (cr.findById(id).isPresent()) {
            ContentArchive contentArchive = new ContentArchive();
            Content oldContent = cr.findById(id).get();

            contentArchive.setTitle(oldContent.getTitle());
            contentArchive.setThumbnail(oldContent.getThumbnail());
            contentArchive.setDescription(oldContent.getDescription());

            Content newContent = new Content(dto);
            contentArchive.setContent(newContent);
            newContent.setId(id);
            car.save(contentArchive);
            return cr.save(newContent);
        }
        return null;
    }

    public void deleteContentById(Long id) {
        car.deleteContentArchivesByContentId(id);
        cr.deleteById(id);
    }

}
