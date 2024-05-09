package com.example.basiccms_backend.repo;

import com.example.basiccms_backend.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepo extends JpaRepository<Content, Long> {
}
