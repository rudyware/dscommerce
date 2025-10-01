package com.projetsweb.dscomerce.repositories;

import com.projetsweb.dscomerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
