package com.example.basiccms_backend.controller;

import com.example.basiccms_backend.dto.ContentDTO;
import com.example.basiccms_backend.model.Content;
import com.example.basiccms_backend.service.ContentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@Tag(name = "BasicCMS API Documentation")
public class APIController {

    private final ContentService cs;

    public APIController(ContentService cs) {
        this.cs = cs;
    }

    @Operation(
            summary = "Fetches all content currently in the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved."),
            @ApiResponse(responseCode = "204", description = "No content in DB.")
    })

    @GetMapping("/content")
    public ResponseEntity<?> getContent() {
        if (!cs.getAllContent().isEmpty()) {
            return ResponseEntity.ok(cs.getAllContent());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @Operation(
            summary = "Adds new content with provided JSON body."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created.")
    })

    @PostMapping("/addcontent")
    public ResponseEntity<?> postContent(@RequestBody ContentDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cs.addContent(new Content(dto)));
    }


    @Operation(
            summary = "Updates content with provided JSON body & id in path."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated."),
            @ApiResponse(responseCode = "404", description = "No content found with given id.")
    })

    @PutMapping("/updatecontent/{id}")
    public ResponseEntity<?> putContent(@RequestBody ContentDTO dto, @PathVariable Long id) {
        if (cs.getContentById(id).isPresent()) {
            Content content = new Content(dto);
            content.setId(id);

            return ResponseEntity.ok(cs.addContent(content));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(
            summary = "Fetches content with provided id."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved."),
            @ApiResponse(responseCode = "404", description = "No content found with given id.")
    })

    @GetMapping("/content/{id}")
    public ResponseEntity<?> findContent(@PathVariable Long id) {
        if (cs.getContentById(id).isPresent()) {
            return ResponseEntity.ok(cs.getContentById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(
            summary = "Deletes link by provided Link ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Link with given ID not found")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLink(@PathVariable Long id){
        if (cs.getContentById(id).isPresent()) {
            cs.deleteContentById(id);
            return ResponseEntity.ok().body("Successfully deleted link with id: " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
