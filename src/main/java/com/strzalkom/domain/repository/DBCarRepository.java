package com.strzalkom.domain.repository;

import com.strzalkom.domain.Car;


import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

public class DBCarRepository implements CarRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void createCar(String name, int cost) {

        Car car = new Car(name, cost);
        em.persist(car);


    }

    @Override
    public Collection<Car> getAllCars() {

       return em.createQuery("from Car", Car.class).getResultList();

    }

    @Override
    public Optional<Car> getCar(String name) {
      Car carByName = em.createQuery("from Car c where c.name=:name", Car.class).setParameter("name",name).getSingleResult();

        return Optional.ofNullable(carByName);
    }

    @Override
    @Transactional
    public void deleteCar(Integer id) {
        em.remove(getCarById(id));

    }

    @Override

    public void build() {

    }

    @Override
    @Transactional
    public void createCar(Car car) {
        em.persist(car);
    }

    @Override
    public Car getCarById(Integer id) {
        return em.find(Car.class, id);
    }
    @Override
    @Transactional
    public void updateCar(int id, Car car){
        em.merge(car);
    }

}
