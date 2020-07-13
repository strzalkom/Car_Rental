package com.strzalkom;

import com.strzalkom.domain.repository.CarRepository;
import com.strzalkom.domain.repository.StateRepository;
import com.strzalkom.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    CarRepository carRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    StateService stateService;

    @Override
    public void run(String... strings) throws Exception {

        stateRepository.createRandomState();
        stateRepository.createRandomState();

        stateService.assignRandomState("Skoda Octavia");

    }

}
