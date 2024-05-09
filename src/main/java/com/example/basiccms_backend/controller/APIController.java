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
    public ResponseEntity<?> postContent(Content content) {
        return ResponseEntity.ok(cs.addContent(content));
    }

    @PutMapping("/updatecontent")
    public ResponseEntity<?> putContent(Content content) {
        return ResponseEntity.ok(cs.addContent(content));
    }

    @GetMapping("/content/{id}")
    public ResponseEntity<?> findContent(@PathVariable Long id) {
        if (cs.getContentById(id).isPresent()){
            return ResponseEntity.ok(cs.getContentById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
