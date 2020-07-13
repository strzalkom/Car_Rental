package com.strzalkom;

import com.strzalkom.domain.Car;
import com.strzalkom.domain.repository.InMemoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CarRentalApplicationTests {

	@Autowired
    Car car;

	@Autowired
	InMemoryRepository inMemoryRepository;

	@Test
	public void contextLoads() {
	}


	}

