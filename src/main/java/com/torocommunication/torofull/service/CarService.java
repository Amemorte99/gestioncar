package com.torocommunication.torofull.service;

import com.sun.org.apache.bcel.internal.generic.ATHROW;
import com.torocommunication.torofull.entities.Car;
import com.torocommunication.torofull.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new ATHROW("Car not found with id " + id) );
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car carDetails) {
        Car car = getCarById(id);

        car.setImmatriculation(carDetails.getImmatriculation());
        car.setMarque(carDetails.getMarque());
        car.setDateAcquisition(carDetails.getDateAcquisition());

        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        Car car = getCarById(id);
        carRepository.delete(car);
    }
}
