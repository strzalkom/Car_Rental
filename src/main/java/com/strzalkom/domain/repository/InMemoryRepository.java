package com.strzalkom.domain.repository;

import com.strzalkom.domain.Car;
import com.strzalkom.utils.Ids;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryRepository implements CarRepository {

    Map<Integer, Car> cars = new HashMap<>();

    public InMemoryRepository() {

    }

    @Override
    public void createCar(String name, int cost) {

        Car newCar = new Car(name, cost);
        newCar.setId(Ids.generateNewId(cars.keySet()));
        cars.put(newCar.getId(), newCar);
    }

    @Override
    public Collection<Car> getAllCars() {
        return cars.values();
    }

    @Override
    public Optional<Car> getCar(String name) {

        Optional<Car> carByName = cars.values().stream().filter(car -> car.getName().equals(name)).findAny();

        return carByName;
    }

    @Override
    public void deleteCar(Integer id) {

        cars.remove(getCarById(id));
    }

    @Override
    @PostConstruct
    public void build() {
        createCar("Skoda Octavia", 190);
        createCar("VW Golf", 150);
    }

    @Override
    public void createCar(Car car) {
        car.setId(Ids.generateNewId(cars.keySet()));
        cars.put(car.getId(), car);
    }

    @Override
    public Car getCarById(Integer id) {
        return cars.get(id);
    }

    @Override
    public String toString() {
        return "InMemoryRepository{" +
                "cars=" + cars +
                '}';
    }

    @Override
    public void updateCar(int id, Car car) {
        cars.put(id,car);
    }

}
