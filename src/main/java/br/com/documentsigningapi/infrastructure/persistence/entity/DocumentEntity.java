package br.com.documentsigningapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_documents")
public class DocumentEntity {

    @Id
    private UUID id;

    private String title;
    private String filePath;
    private String fileFormat;
    private LocalDateTime uploadDate;

    private boolean isSigned;
    private LocalDateTime signedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity owner;

    public DocumentEntity() {
    }

    public DocumentEntity(UUID id, String title, String filePath, String fileFormat, LocalDateTime uploadDate, boolean isSigned, LocalDateTime signedAt, UserEntity owner) {
        this.id = id;
        this.title = title;
        this.filePath = filePath;
        this.fileFormat = fileFormat;
        this.uploadDate = uploadDate;
        this.isSigned = isSigned;
        this.signedAt = signedAt;
        this.owner = owner;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    public String getFileFormat() { return fileFormat; }
    public void setFileFormat(String fileFormat) { this.fileFormat = fileFormat; }

    public LocalDateTime getUploadDate() { return uploadDate; }
    public void setUploadDate(LocalDateTime uploadDate) { this.uploadDate = uploadDate; }

    public boolean isSigned() { return isSigned; }
    public void setSigned(boolean signed) { isSigned = signed; }

    public LocalDateTime getSignedAt() { return signedAt; }
    public void setSignedAt(LocalDateTime signedAt) { this.signedAt = signedAt; }

    public UserEntity getOwner() { return owner; }
    public void setOwner(UserEntity owner) { this.owner = owner; }
}