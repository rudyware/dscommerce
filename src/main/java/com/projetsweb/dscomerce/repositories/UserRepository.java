package com.projetsweb.dscomerce.repositories;

import com.projetsweb.dscomerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
