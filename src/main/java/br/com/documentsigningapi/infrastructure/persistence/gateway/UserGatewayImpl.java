package br.com.documentsigningapi.infrastructure.persistence.gateway;

import br.com.documentsigningapi.domain.entity.User;
import br.com.documentsigningapi.domain.gateway.UserGateway;
import br.com.documentsigningapi.infrastructure.persistence.entity.UserEntity;
import br.com.documentsigningapi.infrastructure.persistence.repository.SpringUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserGatewayImpl implements UserGateway {

    private final SpringUserRepository repository;

    public UserGatewayImpl(SpringUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User userDomain) {
        UserEntity entity = new UserEntity(
                userDomain.getId(),
                userDomain.getName(),
                userDomain.getEmail(),
                userDomain.getBirthDate()
        );

        UserEntity savedEntity = repository.save(entity);

        return new User(
                savedEntity.getId(),
                savedEntity.getName(),
                savedEntity.getEmail(),
                savedEntity.getBirthDate()
        );
    }

    @Override
    public List<User> findAll() {
        return repository.findAll().stream()
                .map(entity -> new User(
                        entity.getId(),
                        entity.getName(),
                        entity.getEmail(),
                        entity.getBirthDate()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id)
                .map(entity -> new User(
                        entity.getId(),
                        entity.getName(),
                        entity.getEmail(),
                        entity.getBirthDate()
                ));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<User> findByName(String name) {
        return List.of();
    }

    @Override
    public User update(User user) {
        return create(user);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}