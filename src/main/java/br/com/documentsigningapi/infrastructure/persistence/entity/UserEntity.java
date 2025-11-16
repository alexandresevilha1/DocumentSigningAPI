package br.com.documentsigningapi.infrastructure.persistence.entity;

import jakarta.persistence.*; // Importa as anotações do JPA (Hibernate)
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class UserEntity {

    @Id
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    private LocalDate birthDate;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<DocumentEntity> documents;

    public UserEntity() {
    }

    public UserEntity(UUID id, String name, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
}