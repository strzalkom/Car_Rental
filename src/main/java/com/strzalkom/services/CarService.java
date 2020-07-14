package com.strzalkom.services;

import com.strzalkom.domain.Car;
import com.strzalkom.domain.repository.CarRepository;
import com.strzalkom.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    StateRepository stateRepository;


    public List<Car> getAllCars() {
        return new ArrayList<>(carRepository.getAllCars());
    }


    public void saveCar(Car car) {
        carRepository.createCar(car);
    }

    public Car getCar(Integer id) {
        return carRepository.getCarById(id);
    }

    public void deleteCar(Integer id) {
        carRepository.deleteCar(id);
    }

    public void updateCar(Car car) {
        carRepository.updateCar(car.getId(), car);
    }



}
