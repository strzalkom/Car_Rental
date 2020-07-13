package com.strzalkom.services;

import com.strzalkom.domain.State;
import com.strzalkom.domain.repository.StateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StateServiceTests {

    @Mock
    StateRepository repositoryMock;

    @Test
    public void returnsNotStartedQuests() {

        List<State> states = new ArrayList<>();
        State q1 = new State(1, "Test quest 1");
        State q2 = new State(2, "Test quest 2");
        State q3 = new State(3, "Test quest 3");

        q2.setStarted(true);

        states.add(q1);
        states.add(q2);
        states.add(q3);


        when(repositoryMock.getAll()).thenReturn(states);

        StateService qs = new StateService();

        qs.setStateRepository(repositoryMock);

        List<State> allNotStartedStates = qs.getAllNotStartedStates();

        assertEquals("Size of returned quest", 2, allNotStartedStates.size());
        assertThat(allNotStartedStates, containsInAnyOrder(q1,q3));
    }
}
