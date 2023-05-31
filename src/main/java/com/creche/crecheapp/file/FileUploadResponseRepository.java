package com.creche.crecheapp.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadResponseRepository extends JpaRepository<FileUploadResponse, Long> {
    // Add any custom repository methods if needed
}