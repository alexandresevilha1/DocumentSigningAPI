package br.com.documentsigningapi.domain.usecase;

import br.com.documentsigningapi.domain.entity.Document;
import br.com.documentsigningapi.domain.gateway.DocumentGateway;

import java.util.UUID;

public class SignDocumentUseCase {

    private final DocumentGateway documentGateway;

    public SignDocumentUseCase(DocumentGateway documentGateway) {
        this.documentGateway = documentGateway;
    }

    public void execute(UUID documentId, UUID userId) {
        Document document = documentGateway.findById(documentId)
                .orElseThrow(() -> new IllegalArgumentException("Document not found"));

        if (!document.getOwner().getId().equals(userId)) {
            throw new IllegalStateException("User is not the owner of this document");
        }

        document.sign();

        documentGateway.save(document);
    }
}