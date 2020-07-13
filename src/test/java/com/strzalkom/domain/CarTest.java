package com.strzalkom.domain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CarTest {


    @Test
    public void testIfQuestMarkedAsStarted() {

        Car car = new Car("Skoda Octavia", 190);
        State state = new State(1,"Testowy stan");

        car.setState(state);

        assertTrue(car.getState().isStarted());


    }
}
