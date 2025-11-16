package br.com.documentsigningapi.domain.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID id;

    private String name;
    private String email;
    private LocalDate birthDate;

    private final List<Document> documents;

    public User(UUID id, String name, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.documents = new ArrayList<>();
    }

    public void addDocument(Document document) {
        if (!document.getOwner().equals(this)) {
            throw new IllegalArgumentException("User is not the owner of this document.");
        }
        this.documents.add(document);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Document> getDocuments() {
        return Collections.unmodifiableList(documents);
    }
}