package com.strzalkom;

import com.strzalkom.domain.repository.CarRepository;
import com.strzalkom.domain.repository.StateRepository;
import com.strzalkom.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    CarRepository carRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    StateService stateService;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {

    stateRepository.createState("Wypożyczony");
    stateRepository.createState("Dostępny");
    stateRepository.createState("Uszkodzony");
    stateRepository.createState("W przygotowaniu");

    carRepository.createCar("Audi A4", 189);

    stateService.assignRandomState("Audi A4");


    }

}
