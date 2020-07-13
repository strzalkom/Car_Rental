package com.strzalkom.services;
import com.strzalkom.domain.State;
import com.strzalkom.domain.repository.CarRepository;
import com.strzalkom.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class StateService {

    @Autowired
    CarRepository carRepository;


    StateRepository stateRepository;

    final static Random rand= new Random();

    public void assignRandomState(String carName) {
        List<State> allStates = stateRepository.getAll();
        State randomState = allStates.get(rand.nextInt(allStates.size()));
        carRepository.getCar(carName).ifPresent(car -> car.setState(randomState));
    }

    public List<State> getAllNotStartedStates() {
        return stateRepository.getAll().stream().filter(state -> !state.isStarted()).collect(Collectors.toList());
    }

    @Autowired
    public void setStateRepository(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public void update(State state) {
        stateRepository.update(state);
    }

    public boolean isStateCompleted(State state) {
        return state.isCompleted();
    }
}
