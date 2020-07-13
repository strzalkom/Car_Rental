package com.strzalkom.config;

import com.strzalkom.domain.repository.CarRepository;
import com.strzalkom.domain.repository.DBCarRepository;
import com.strzalkom.domain.repository.InMemoryRepository;
import org.springframework.context.annotation.*;

@Configuration
public class MainConfig {


    @Bean(name="inMemoryCarRepository")
    @Profile("dev")
    public CarRepository createInMemoryRepo() {
        CarRepository repo = new InMemoryRepository();
        return repo;
    }

    @Bean(name="DBCarRepository")
    @Profile("prod")
    public CarRepository createDBRepo() {
       CarRepository repo = new DBCarRepository();
        return repo;
    }

}
