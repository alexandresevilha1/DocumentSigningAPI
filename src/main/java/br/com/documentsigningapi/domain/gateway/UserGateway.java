package br.com.documentsigningapi.domain.gateway;

import br.com.documentsigningapi.domain.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserGateway {

    User create(User user);

    List<User> findAll();
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    List<User> findByName(String name);

    User update(User user);
    void delete(UUID id);
}