package com.example.basiccms_backend.repo;


import com.example.basiccms_backend.model.ContentArchive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentArchiveRepo extends JpaRepository<ContentArchive, Long> {
}
