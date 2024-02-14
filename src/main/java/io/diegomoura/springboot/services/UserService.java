package io.diegomoura.springboot.services;

import io.diegomoura.springboot.entities.User;
import io.diegomoura.springboot.repositories.UserRepository;
import io.diegomoura.springboot.services.exceptions.DataBaseException;
import io.diegomoura.springboot.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<User> findAll() {
        return repository.findAll();
    }
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    // Inserindo User no BD
    public User insert(User obj) {
        return repository.save(obj);
    }

    // Deletando User BD
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e1) {
            throw new DataBaseException(e1.getMessage());
        }
    }

    // Atualizando User no BD
    public User update(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

    }
    private void updateData(User entity, User obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setTelefone(obj.getTelefone());
    }

}
