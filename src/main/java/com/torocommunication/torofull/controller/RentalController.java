package com.torocommunication.torofull.controller;

import com.torocommunication.torofull.entities.Car;
import com.torocommunication.torofull.entities.Customer;
import com.torocommunication.torofull.entities.Employee;
import com.torocommunication.torofull.entities.Rental;
import com.torocommunication.torofull.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping("/")
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable Long id) {
        return rentalService.getRentalById(id);
    }

    @PostMapping("/")
    public Rental addRental(@RequestBody Rental rental) {
        return rentalService.saveRental(rental);
    }

    @PutMapping("/{id}")
    public Rental updateRental(@PathVariable Long id, @RequestBody Rental rental) {
        Rental existingRental = rentalService.getRentalById(id);
        if (existingRental != null) {
            rental.setId(id);
            return rentalService.saveRental(rental);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
    }

    @GetMapping("/employee/{employeeId}")
    public List<Rental> getRentalsByEmployee(@PathVariable Long employeeId) {
        Employee employee = new Employee();
        employee.setId(employeeId);
        return rentalService.getRentalsByEmployee(employee);
    }

    @GetMapping("/car/{carId}")
    public List<Rental> getRentalsByCar(@PathVariable Long carId) {
        Car car = new Car();
        car.setId(carId);
        return rentalService.getRentalsByCar(car);
    }

    @GetMapping("/customer/{customerId}")
    public List<Rental> getRentalsByCustomer(@PathVariable Long customerId) {
        Customer customer = new Customer();
        customer.setId(customerId);
        return rentalService.getRentalsByCustomer(customer);
    }

    @GetMapping("/period")
    public List<Rental> getRentalsDuringPeriod(@RequestParam("start") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                                               @RequestParam("end") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
        return rentalService.getRentalsDuringPeriod(startDate, endDate);
    }

    @GetMapping("/overlapping")
    public List<Rental> getRentalsOverlappingPeriod(@RequestParam("start") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                                                    @RequestParam("end") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
        return rentalService.getRentalsOverlappingPeriod(startDate, endDate);
    }

}

