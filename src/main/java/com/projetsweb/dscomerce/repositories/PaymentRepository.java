package com.projetsweb.dscomerce.repositories;

import com.projetsweb.dscomerce.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
