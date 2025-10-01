package com.projetsweb.dscomerce.repositories;

import com.projetsweb.dscomerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
