package br.com.documentsigningapi.domain.usecase;

import br.com.documentsigningapi.domain.entity.User;
import br.com.documentsigningapi.domain.gateway.UserGateway;

import java.time.LocalDate;
import java.util.UUID;

public class CreateUserUseCase {

    private final UserGateway userGateway;

    public CreateUserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User execute(String name, String email, LocalDate birthDate) {
        if (userGateway.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("User with email " + email + " already exists.");
        }

        User newUser = new User(
                UUID.randomUUID(),
                name,
                email,
                birthDate
        );

        return userGateway.create(newUser);
    }
}