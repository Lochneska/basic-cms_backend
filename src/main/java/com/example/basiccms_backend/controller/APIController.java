package com.example.basiccms_backend.controller;

import com.example.basiccms_backend.model.Content;
import com.example.basiccms_backend.service.ContentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class APIController {

    private final ContentService cs;

    public APIController(ContentService cs) {
        this.cs = cs;
    }

    @GetMapping("/content")
    public ResponseEntity<?> getContent() {
        return ResponseEntity.ok(cs.getAllContent());
    }

    @PostMapping("/addcontent")
    public ResponseEntity<?> postContent(@RequestBody Content content) {
        if (content.getId() == null) {
            return ResponseEntity.ok(cs.addContent(content));
        } else {
            return ResponseEntity.badRequest().body("Cannot update content via /api/addcontent endpoint.");
        }
    }

    @PutMapping("/updatecontent/{id}")
    public ResponseEntity<?> putContent(@RequestBody Content content, @PathVariable Long id) {
        if (cs.getContentById(id).isPresent()) {
            content.setId(id);
            return ResponseEntity.ok(cs.addContent(content));
        } else {
            return ResponseEntity.badRequest().body("Content with id " + id + " not found.");
        }
    }

    @GetMapping("/content/{id}")
    public ResponseEntity<?> findContent(@PathVariable Long id) {
        if (cs.getContentById(id).isPresent()) {
            return ResponseEntity.ok(cs.getContentById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
