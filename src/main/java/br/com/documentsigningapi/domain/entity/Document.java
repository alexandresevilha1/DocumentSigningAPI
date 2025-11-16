package br.com.documentsigningapi.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Document {
    private final UUID id;
    private final String title;
    private final String filePath;
    private final String fileFormat;
    private final LocalDateTime uploadDate;
    private final User owner;

    private boolean isSigned;
    private LocalDateTime signedAt;

    public Document(UUID id, String title, String filePath, String fileFormat, User owner) {
        this.id = id;
        this.title = title;
        this.filePath = filePath;
        this.fileFormat = fileFormat;
        this.owner = owner;

        this.uploadDate = LocalDateTime.now();

        this.isSigned = false;
        this.signedAt = null;
    }

    public UUID getId() { return id; }
    public String getTitle() { return title; }
    public String getFilePath() { return filePath; }
    public String getFileFormat() { return fileFormat; }
    public LocalDateTime getUploadDate() { return uploadDate; }
    public User getOwner() { return owner; }
    public boolean isSigned() { return isSigned; }
    public LocalDateTime getSignedAt() { return signedAt; }

    public void sign() {
        if (this.isSigned) {
            throw new IllegalStateException("Document is already signed.");
        }
        this.isSigned = true;
        this.signedAt = LocalDateTime.now();
    }
}