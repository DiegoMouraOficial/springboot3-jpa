package io.diegomoura.springboot.services;

import io.diegomoura.springboot.entities.User;
import io.diegomoura.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
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
        return obj.get();
    }
    // Inserindo no BD um novo obejto do tipo User
    public User insert(User obj) {
        return repository.save(obj);
    }

}
