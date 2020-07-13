package com.strzalkom.domain;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class StateTest {


    @Test
    public void settingStartedFlagToFalseShouldSetStartDate() {
        State state = new State(1, "Stan Testowy");

        state.setStarted(true);

        assertNotNull(state.startDate);
    }

    @Test
    public void questShouldBeCompleted() {
        State state = new State(1, "Stan testowy");
        state.setStarted(true);
        state.lenghtInSeconds = -60;
        assertTrue(state.isCompleted());
        assertTrue(state.isCompleted());
    }


    @Test
    public void questShouldNotBeCompleted() {
        State state = new State(1, "Stan Testowy");
        state.setStarted(true);
        state.lenghtInSeconds = 20000;
        assertFalse(state.isCompleted());
        assertFalse(state.isCompleted());
    }
}
