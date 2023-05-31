package com.creche.crecheapp.file;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "file")
public class FileUploadResponse {
    @GeneratedValue
    @Id
    private long id;

    private String fileName;
    private String downloadUri;
    private long size;

    public FileUploadResponse() {
    }

    public FileUploadResponse(String fileName, String downloadUri, long size) {
        this.fileName = fileName;
        this.downloadUri = downloadUri;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDownloadUri() {
        return downloadUri;
    }

    public long getSize() {
        return size;
    }


    public void setId(long id) {
        this.id = id;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public void setDownloadUri(String downloadUri) {
        this.downloadUri = downloadUri;
    }

    public void setSize(long size) {
        this.size = size;
    }

// Getters and setters
}
