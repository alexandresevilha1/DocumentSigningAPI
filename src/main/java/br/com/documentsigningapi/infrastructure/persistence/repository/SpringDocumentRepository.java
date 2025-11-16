package br.com.documentsigningapi.infrastructure.persistence.repository;

import br.com.documentsigningapi.infrastructure.persistence.entity.DocumentEntity;
import br.com.documentsigningapi.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface SpringDocumentRepository extends JpaRepository<DocumentEntity, UUID> {
    List<DocumentEntity> findAllByOwner(UserEntity owner);

    List<DocumentEntity> findAllByFileFormat(String fileFormat);

    List<DocumentEntity> findByTitle(String title);

    List<DocumentEntity> findBySignedAtAfter(LocalDateTime date);

    List<DocumentEntity> findAllByUploadDate(LocalDateTime uploadDate);

    List<DocumentEntity> findAllByIsSigned(boolean isSigned);

    List<DocumentEntity> findAllBySignedAt(LocalDateTime signedAt);
}