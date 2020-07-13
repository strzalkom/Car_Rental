package com.strzalkom.domain.repository;

import com.strzalkom.domain.State;
import com.strzalkom.utils.Ids;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class StateRepository {


    Random rand = new Random();

    Map<Integer, State> states = new HashMap<>();


    public void createState(String description) {
        int newId = Ids.generateNewId(states.keySet());
        State newState = new State(newId, description);
        states.put(newId, newState);
    }

    public List<State> getAll() {
        return  new ArrayList<>(states.values());
    }

    public void deleteState(State state) {
        states.remove(state.getId());
    }

    @PostConstruct
    public void init() {

    }

    @Override
    public String toString() {
        return "StateRepository{" +
                "states=" + states +
                '}';
    }


    public void createRandomState() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Wypożyczony");
        descriptions.add("Dostępny");
        descriptions.add("Uszkodzony");
        descriptions.add("W przygotowaniu");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        createState(description);
    }

    public void update(State state) {
        states.put(state.getId(), state);
    }

    public State getState(Integer id) {
        return states.get(id);
    }
}
