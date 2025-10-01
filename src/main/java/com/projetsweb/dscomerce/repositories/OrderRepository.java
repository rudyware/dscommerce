package com.projetsweb.dscomerce.repositories;

import com.projetsweb.dscomerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
