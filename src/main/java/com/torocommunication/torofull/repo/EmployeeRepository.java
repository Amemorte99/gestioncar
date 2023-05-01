package com.torocommunication.torofull.repo;

import com.torocommunication.torofull.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Ajouter ici des méthodes personnalisées pour effectuer des requêtes sur la base de données
}

