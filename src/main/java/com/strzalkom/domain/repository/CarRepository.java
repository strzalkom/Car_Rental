package com.strzalkom.domain.repository;

import com.strzalkom.domain.Car;
import java.util.Collection;
import java.util.Optional;

public interface CarRepository {

    void createCar(String name, int cost);

    Collection<Car> getAllCars();

    Optional<Car> getCar(String name);

    void deleteCar(Integer id);

    void build();

    void createCar(Car car);

    Car getCarById(Integer id);

    default void updateCar(int id, Car car) { throw null; }
}
