package com.torocommunication.torofull.repo;

import com.torocommunication.torofull.entities.Car;
import com.torocommunication.torofull.entities.Customer;
import com.torocommunication.torofull.entities.Employee;
import com.torocommunication.torofull.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByEmployee(Employee employee);
    List<Rental> findByCar(Car car);
    List<Rental> findByCustomer(Customer customer);
    List<Rental> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(Date startDate, Date endDate);
    List<Rental> findByStartDateLessThanAndEndDateGreaterThan(Date startDate, Date endDate);
}

