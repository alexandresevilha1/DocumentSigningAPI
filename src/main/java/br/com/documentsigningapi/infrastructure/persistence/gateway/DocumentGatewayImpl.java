package br.com.documentsigningapi.infrastructure.persistence.gateway;

import br.com.documentsigningapi.domain.entity.Document;
import br.com.documentsigningapi.domain.entity.User;
import br.com.documentsigningapi.domain.gateway.DocumentGateway;
import br.com.documentsigningapi.infrastructure.persistence.entity.DocumentEntity;
import br.com.documentsigningapi.infrastructure.persistence.entity.UserEntity;
import br.com.documentsigningapi.infrastructure.persistence.repository.SpringDocumentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DocumentGatewayImpl implements DocumentGateway {

    private final SpringDocumentRepository repository;

    public DocumentGatewayImpl(SpringDocumentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Document save(Document document) {
        DocumentEntity entity = new DocumentEntity(
                document.getId(),
                document.getTitle(),
                document.getFilePath(),
                document.getFileFormat(),
                document.getUploadDate(),
                document.isSigned(),
                document.getSignedAt(),
                new UserEntity(
                        document.getOwner().getId(),
                        document.getOwner().getName(),
                        document.getOwner().getEmail(),
                        document.getOwner().getBirthDate()
                )
        );

        DocumentEntity savedEntity = repository.save(entity);

        return toDomain(savedEntity);
    }

    @Override
    public List<Document> findAll() {
        return repository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Document> findById(UUID id) {
        return repository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Document> findByOwner(User owner) {
        UserEntity ownerEntity = new UserEntity();
        ownerEntity.setId(owner.getId());

        return repository.findAllByOwner(ownerEntity).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Document> findByTitle(String title) {
        List<DocumentEntity> entities = repository.findByTitle(title);

        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Document> findByFileFormat(String fileFormat) {
        return repository.findAllByFileFormat(fileFormat).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Document> findByIsSigned(boolean isSigned) {
        return repository.findAllByIsSigned(isSigned).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Document> findBySignedAtAfter(LocalDateTime date) {
        List<DocumentEntity> entities = repository.findBySignedAtAfter(date);

        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private Document toDomain(DocumentEntity entity) {

        User ownerDomain = new User(
                entity.getOwner().getId(),
                entity.getOwner().getName(),
                entity.getOwner().getEmail(),
                entity.getOwner().getBirthDate()
        );

        return new Document(
                entity.getId(),
                entity.getTitle(),
                entity.getFilePath(),
                entity.getFileFormat(),
                entity.getUploadDate(),
                entity.isSigned(),
                entity.getSignedAt(),
                ownerDomain
        );
    }
}