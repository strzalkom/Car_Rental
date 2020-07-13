package com.strzalkom.domain.repository;

import com.strzalkom.domain.Car;


import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Optional;

public class DBCarRepository implements CarRepository {

    @Override
    public void createCar(String name, int cost) {

        System.out.println("uzywam bazy danych");
        throw null;
    }

    @Override
    public Collection<Car> getAllCars() {
        System.out.println("uzywam bazy danych");
        throw null;
    }

    @Override
    public Optional<Car> getCar(String name) {
        System.out.println("uzywam bazy danych");
        throw null;
    }

    @Override
    public void deleteCar(Integer id) {
        System.out.println("uzywam bazy danych");
        throw null;
    }

    @Override
    @PostConstruct
    public void build() {

    }

    @Override
    public void createCar(Car car) {
        System.out.println("uzywam bazy danych");
        throw null;
    }

    @Override
    public Car getCarById(Integer id) {
        System.out.println("uzywam bazy danych");
        throw null;
    }


}
