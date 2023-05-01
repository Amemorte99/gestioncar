package com.torocommunication.torofull.repo;

import com.torocommunication.torofull.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Ajouter ici des méthodes personnalisées pour effectuer des requêtes sur la base de données
}
