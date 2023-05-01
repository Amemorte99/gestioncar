package com.torocommunication.torofull.service;

import com.torocommunication.torofull.entities.Car;
import com.torocommunication.torofull.entities.Customer;
import com.torocommunication.torofull.entities.Employee;
import com.torocommunication.torofull.entities.Rental;
import com.torocommunication.torofull.repo.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }

    public List<Rental> getRentalsByEmployee(Employee employee) {
        return rentalRepository.findByEmployee(employee);
    }

    public List<Rental> getRentalsByCar(Car car) {
        return rentalRepository.findByCar(car);
    }

    public List<Rental> getRentalsByCustomer(Customer customer) {
        return rentalRepository.findByCustomer(customer);
    }

    public List<Rental> getRentalsDuringPeriod(Date startDate, Date endDate) {
        return rentalRepository.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(startDate, endDate);
    }

    public List<Rental> getRentalsOverlappingPeriod(Date startDate, Date endDate) {
        return rentalRepository.findByStartDateLessThanAndEndDateGreaterThan(startDate, endDate);
    }

}
