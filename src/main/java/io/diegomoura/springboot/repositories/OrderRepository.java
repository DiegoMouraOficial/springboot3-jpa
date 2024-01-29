package io.diegomoura.springboot.repositories;

import io.diegomoura.springboot.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
