package br.com.documentsigningapi.domain.gateway;

import br.com.documentsigningapi.domain.entity.Document;
import br.com.documentsigningapi.domain.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DocumentGateway {
    Document save(Document document);

    List<Document> findAll();
    Optional<Document> findById(UUID id);

    List<Document> findByOwner(User owner);
    List<Document> findByTitle(String title);
    List<Document> findByFileFormat(String fileFormat);
    List<Document> findByIsSigned(boolean isSigned);

    List<Document> findBySignedAtAfter(LocalDateTime date);

    void delete(UUID id);
}