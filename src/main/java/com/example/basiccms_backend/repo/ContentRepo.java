package com.example.basiccms_backend.repo;

import com.example.basiccms_backend.model.Content;
import org.springframework.data.repository.CrudRepository;

public interface ContentRepo extends CrudRepository<Content, Long> {
}
