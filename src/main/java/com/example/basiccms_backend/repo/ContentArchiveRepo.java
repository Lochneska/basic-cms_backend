package com.example.basiccms_backend.repo;


import com.example.basiccms_backend.model.ContentArchive;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentArchiveRepo extends JpaRepository<ContentArchive, Long> {

    @Transactional
    public void deleteContentArchivesByContentId(Long content_id);
}
