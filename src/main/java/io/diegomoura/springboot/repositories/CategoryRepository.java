package io.diegomoura.springboot.repositories;

import io.diegomoura.springboot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
