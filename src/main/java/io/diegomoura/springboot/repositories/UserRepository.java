package io.diegomoura.springboot.repositories;

import io.diegomoura.springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
